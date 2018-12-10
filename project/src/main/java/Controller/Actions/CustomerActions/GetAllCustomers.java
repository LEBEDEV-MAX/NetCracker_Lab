package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Model.CustomerDB;
import View.PrintAllCustomers;

import java.util.Map;

public class GetAllCustomers implements Command {
    private CustomerDB db;
    private PrintAllCustomers pac;

    public GetAllCustomers(CustomerDB db, PrintAllCustomers pac){
        this.db = db;
        this.pac = pac;
    }

    @Override
    public void execute(Map<String, String> map){
        pac.print(db);
    }

    public CustomerDB getDb(){
            return db;
    }
}
