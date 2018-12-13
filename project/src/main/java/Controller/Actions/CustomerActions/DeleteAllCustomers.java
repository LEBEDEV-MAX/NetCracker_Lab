package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Model.CustomerDB;
import View.PrintComplete;

import java.util.Map;

/**
 * This class delete all customers in DB
 */
public class DeleteAllCustomers implements Command {
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;

    public DeleteAllCustomers(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     */
    @Override
    public void execute(Map<String, String> map){
        db.deleteAllCustomers();
    }
}
