package Controller.CustomerActions;

import Controller.Command;
import Model.Customer;
import Model.CustomerDB;
import View.PrintComplete;
import View.PrintException;

import java.util.Map;

public class UpdateCustomer implements Command{
    private CustomerDB db;

    public UpdateCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        try{
            int index = getID(map);
            Customer customer = db.getCustomer(index);
            if(customer != null){
                if(map.get("name=") != null)
                    customer.setName(map.get("name="));
                if(map.get("phone=") != null)
                    customer.setPhone(map.get("phone="));
                if(map.get("address=") != null)
                    customer.setAddress(map.get("address="));

                PrintComplete printer = new PrintComplete();
                printer.printComplete();
            }
            else{
                printException(new NullPointerException());
            }
        }
        catch (Exception e){
            printException(e);
        }
    }

    private int getID(Map<String, String> map) throws NullPointerException, NumberFormatException{
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

    private void printException(Exception e){
        PrintException printer = new PrintException();
        printer.print(e);
    }
}
