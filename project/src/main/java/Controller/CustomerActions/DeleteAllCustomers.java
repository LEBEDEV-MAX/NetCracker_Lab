package Controller.CustomerActions;

import Controller.Command;
import Model.CustomerDB;

import java.util.Map;

public class DeleteAllCustomers implements Command {
    private CustomerDB db;

    public DeleteAllCustomers(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        db.deleteAllCustomers();
    }
}
