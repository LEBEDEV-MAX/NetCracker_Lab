package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.CustomerNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

/**
 * This class update data of customer by his id
 */
public class UpdateCustomer implements Command{
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;

    public UpdateCustomer(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     * @throws WrongArgumentException when user wrote wrong id argument
     * @see Controller.Exceptions.WrongArgumentException
     * @throws WrongParameterException when user wrote wrong id | name | phone | address parameters
     * @see Controller.Exceptions.WrongParameterException
     * @throws CustomerNotFoundException when customer not found in DB by id
     * @see Controller.Exceptions.CustomerNotFoundException
     */
    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException,
            CustomerNotFoundException {
        try{
            int id = getID(map);
            Customer customer = getCustomerByID(id);

            if(map.get("name") != null)
                customer.setName(map.get("name"));
            if(map.get("phone") != null)
                customer.setPhone(map.get("phone"));
            if(map.get("address") != null)
                customer.setAddress(map.get("address"));
        }
        catch (Exception e){
            throw e;
        }
    }

    /**
     * This method returns id argument of customer from map
     * @param map contains (parameter -> argument)
     * @return id of customer
     * @throws WrongArgumentException when user wrote wrong id argument
     * @see Controller.Exceptions.WrongArgumentException
     * @throws WrongParameterException when user wrote wrong id parameter
     * @see Controller.Exceptions.WrongParameterException
     */
    private int getID(Map<String, String> map) throws WrongArgumentException, WrongParameterException {
        String id = map.get("id");
        if(id != null){
            try{
                return Integer.parseInt(id);
            }
            catch (Exception e){
                throw new WrongArgumentException("id = " + id + " in UpdateCustomer command");
            }
        }
        else{
            throw new WrongParameterException("parameter 'id' not found in UpdateCustomer command");
        }
    }

    /**
     * This method get customer by his id from DB
     * @param id of customer
     * @return Customer whose you want to get
     * @throws CustomerNotFoundException when customer not found in DB by id
     * @see Controller.Exceptions.CustomerNotFoundException
     */
    private Customer getCustomerByID(int id) throws CustomerNotFoundException {
        Customer customer = db.getCustomer(id);
        if (customer != null) {
            return customer;
        }
        else{
            throw new CustomerNotFoundException("by id = " + id + " in UpdateCustomer command");
        }
    }
}
