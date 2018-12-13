package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.GetAllCustomers;
import Model.CustomerDB;
import View.CustomersView.PrintAllCustomers;

/**
 * This class create new GetAllCustomers command
 */
public class GetAllCustomersFactory implements CommandFactory {
    private CustomerDB db;
    private PrintAllCustomers pac;

    public GetAllCustomersFactory(CustomerDB db, PrintAllCustomers pac){
        this.db = db;
        this.pac = pac;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.GetAllCustomers
     */
    @Override
    public Command createCommand(){
        return new GetAllCustomers(db, pac);
    }

    public CustomerDB getDb() {
        return db;
    }
}
