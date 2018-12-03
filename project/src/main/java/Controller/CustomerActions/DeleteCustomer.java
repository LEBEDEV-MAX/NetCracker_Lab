package Controller.CustomerActions;

import Controller.Command;
import Model.CustomerDB;
import View.PrintComplete;
import View.PrintException;

import java.util.Map;

public class DeleteCustomer implements Command{
    private CustomerDB db;

    public DeleteCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        try{
            int index = getID(map);
            db.deleteCustomer(index);

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

    private void printException(Exception e){
        PrintException printer = new PrintException();
        printer.print(e);
    }
}
