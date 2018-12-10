package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.CustomerNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

public class UpdateCustomer implements Command{
    private CustomerDB db;

    public UpdateCustomer(CustomerDB db){
        this.db = db;
    }

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

    private int getID(Map<String, String> map) throws WrongArgumentException, WrongParameterException {
        if(map.get("id") != null){
            try{
                return Integer.parseInt(map.get("id"));
            }
            catch (Exception e){
                throw new WrongArgumentException();
            }
        }
        else{
            throw new WrongParameterException();
        }
    }

    public Customer getCustomerByID(int id) throws CustomerNotFoundException {
        if (db.getCustomer(id) != null) {
            return db.getCustomer(id);
        }
        else{
            throw new CustomerNotFoundException();
        }
    }
}
