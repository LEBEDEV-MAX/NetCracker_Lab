package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.CustomerNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.CustomerDB;

import java.util.Map;

public class DeleteCustomer implements Command{
    private CustomerDB db;

    public DeleteCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException,
            CustomerNotFoundException{
        try{
            int index = getID(map);
            db.deleteCustomer(index);
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
}
