package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Model.CustomerDB;
import View.CustomersView.PrintAllCustomers;

import java.util.Map;

/**
 * This class create get about all customers and prints their on screen
 */
public class GetAllCustomers implements Command {
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;
    /**
     * @see View.CustomersView.PrintAllCustomers
     */
    private PrintAllCustomers pac;

    public GetAllCustomers(CustomerDB db, PrintAllCustomers pac){
        this.db = db;
        this.pac = pac;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     */
    @Override
    public void execute(Map<String, String> map){
        pac.print(db);
    }

    public CustomerDB getDb(){
            return db;
    }
}
