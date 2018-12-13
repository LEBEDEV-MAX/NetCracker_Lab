package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.DeleteCustomer;
import Model.CustomerDB;

/**
 * This class create new DeleteCustomer command
 */
public class DeleteCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public DeleteCustomerFactory(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.DeleteCustomer
     */
    @Override
    public Command createCommand(){
        return new DeleteCustomer(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
