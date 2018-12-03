package Controller.CustomerActions;

import Controller.Command;
import Model.CustomerDB;
import View.PrintAllCustomers;

import java.util.Map;

public class GetAllCustomers implements Command {
    private CustomerDB db;

    public GetAllCustomers(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        PrintAllCustomers printer = new PrintAllCustomers();
        printer.print(db);
    }

    public CustomerDB getDb(){
            return db;
    }
}
