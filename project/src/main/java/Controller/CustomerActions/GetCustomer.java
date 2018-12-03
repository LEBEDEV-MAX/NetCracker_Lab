package Controller.CustomerActions;

import Controller.Command;
import Model.Customer;
import Model.CustomerDB;
import View.PrintCustomer;
import View.PrintException;

import java.util.Map;

public class GetCustomer implements Command {
    private CustomerDB db;

    public GetCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        try{
            Customer customer = getCustomerByID(map);
            PrintCustomer printer = new PrintCustomer();
            printer.print(customer);
        }
        catch (Exception e){
            printException(e);
        }
    }

    public Customer getCustomerByID(Map<String, String> map) throws IllegalArgumentException, NumberFormatException{
        if(map.get("id") != null){
            try{
                int index = Integer.parseInt(map.get("id"));
                return db.getCustomer(index);
            }
            catch (NumberFormatException e){
                throw e;
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    private void printException(Exception e){
        PrintException printer = new PrintException();
        printer.print(e);
    }
}
