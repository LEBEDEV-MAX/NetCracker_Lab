package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.CreateCustomer;
import Model.CustomerDB;

/**
 * This class create new CreateCustomer command
 */
public class CreateCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public CreateCustomerFactory(CustomerDB db){
        this.db = db;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.CreateCustomer
     */
    @Override
    public Command createCommand(){
        return new CreateCustomer(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
