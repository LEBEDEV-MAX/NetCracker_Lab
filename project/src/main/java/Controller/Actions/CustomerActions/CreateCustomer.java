package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

public class CreateCustomer implements Command {
    private CustomerDB db;

    public CreateCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException{
        try {
            Customer customer = new Customer(
                    getID(map),
                    getStringArgument(map,"name"),
                    getStringArgument(map,"phone"),
                    getStringArgument(map,"address")
            );
            db.addCustomer(customer);
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

    private String getStringArgument(Map<String, String> map, String argumentName) throws WrongParameterException {
        if(map.get(argumentName) != null)
            return map.get(argumentName);
        else
            throw new WrongParameterException();
    }
}
