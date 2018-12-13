package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.DeleteAllCustomers;
import Model.CustomerDB;

/**
 * This class create new DeleteAllCustomers command
 */
public class DeleteAllCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public DeleteAllCustomerFactory(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.DeleteAllCustomers
     */
    @Override
    public Command createCommand(){
        return new DeleteAllCustomers(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
