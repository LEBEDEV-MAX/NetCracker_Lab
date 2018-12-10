package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Model.CustomerDB;
import View.PrintComplete;

import java.util.Map;

public class DeleteAllCustomers implements Command {
    private CustomerDB db;

    public DeleteAllCustomers(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        db.deleteAllCustomers();
        PrintComplete printer = new PrintComplete();
        printer.print();
    }
}
