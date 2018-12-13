package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.UpdateCustomer;
import Model.CustomerDB;

/**
 * This class create new UpdateCustomer command
 */
public class UpdateCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public UpdateCustomerFactory(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.UpdateCustomer
     */
    @Override
    public Command createCommand(){
        return new UpdateCustomer(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
