package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.CustomerNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.CustomerDB;

import java.util.Map;

/**
 * This class delete customer by his id
 */
public class DeleteCustomer implements Command{
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;

    public DeleteCustomer(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     * @throws WrongArgumentException when user wrote wrong id argument
     * @see Controller.Exceptions.WrongArgumentException
     * @throws WrongParameterException when user wrote wrong id | name | phone | address parameters
     * @see Controller.Exceptions.WrongParameterException
     */
    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException,
            CustomerNotFoundException{
        try{
            int id = getID(map);
            db.deleteCustomer(id);
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
                throw new WrongArgumentException("id = " + id + " in DeleteCustomer command" );
            }
        }
        else{
            throw new WrongParameterException("parameter 'id' not found in DeleteCustomer command");
        }
    }
}
