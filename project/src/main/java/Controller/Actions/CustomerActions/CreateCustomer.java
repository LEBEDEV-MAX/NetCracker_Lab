package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.ExistCustomerException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

/**
 * This class create new customer and add his to DB
 */
public class CreateCustomer implements Command {
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;

    public CreateCustomer(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     * @throws WrongArgumentException when user wrote wrong id argument
     * @see Controller.Exceptions.WrongArgumentException
     * @throws WrongParameterException when user wrote wrong id | name | phone | address parameters
     * @see Controller.Exceptions.WrongParameterException
     * @throws ExistCustomerException when customer with id is already exist
     * @see Controller.Exceptions.ExistCustomerException
     */
    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException,
            ExistCustomerException{
        ///////////////////////////
        try {
            Customer customer = new Customer(
                    getID(map),
                    getStringArgument(map,"name"),
                    getStringArgument(map,"phone"),
                    getStringArgument(map,"address")
            );

            if(checkExistCustomerByID(customer.getId())) db.addCustomer(customer);
            else throw new ExistCustomerException("with this id = " + customer.getId() + " in CreateCustomer command");
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
                throw new WrongArgumentException("id = " + id + " in CreateCustomer command");
            }
        }
        else{
            throw new WrongParameterException("parameter 'id' not found in CreateCustomer command");
        }
    }

    /**
     * This method returns argument by his parameter name from map
     * @param map contains (parameter -> argument)
     * @param parameterName which argument do you want to get
     * @throws WrongParameterException when user wrote wrong name | phone | address parameters
     * @see Controller.Exceptions.WrongParameterException
     */
    private String getStringArgument(Map<String, String> map, String parameterName) throws WrongParameterException {
        String argument = map.get(parameterName);
        if(argument != null)
            return argument;
        else
            throw new WrongParameterException("parameter '" + parameterName + "' not found in CreateCustomer command");
    }

    /**
     * This method check exist customer in DB or not
     * @param id of customer
     * @return true - if customer already exist; false - if not
     * @see Model.CustomerDB#getCustomer(int)
     */
    private boolean checkExistCustomerByID(int id){
        if (db.getCustomer(id) == null) return true;
        else return false;
    }
}
