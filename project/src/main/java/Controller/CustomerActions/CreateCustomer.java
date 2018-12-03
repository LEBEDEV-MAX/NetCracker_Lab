package Controller.CustomerActions;

import Controller.Command;
import Model.Customer;
import Model.CustomerDB;
import View.PrintComplete;
import View.PrintException;

import java.util.Map;

public class CreateCustomer implements Command {
    private CustomerDB db;

    public CreateCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        try {
            Customer customer = new Customer(
                    getID(map),
                    getStringArgument(map,"name"),
                    getStringArgument(map,"phone"),
                    getStringArgument(map,"address")
            );
            db.addCustomer(customer);

            PrintComplete printer = new PrintComplete();
            printer.printComplete();
        }
        catch (Exception e){
            printException(e);
        }
    }

    private int getID(Map<String, String> map) throws IllegalArgumentException, NumberFormatException{
        if(map.get("id") != null){
            try{
                return Integer.parseInt(map.get("id"));
            }
            catch (NumberFormatException e){
                throw e;
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    private String getStringArgument(Map<String, String> map, String argumentName) throws IllegalArgumentException{
        if(map.get(argumentName) != null)
            return map.get(argumentName);
        else
            throw new IllegalArgumentException();
    }

    private void printException(Exception e){
        PrintException printer = new PrintException();
        printer.print(e);
    }
}
