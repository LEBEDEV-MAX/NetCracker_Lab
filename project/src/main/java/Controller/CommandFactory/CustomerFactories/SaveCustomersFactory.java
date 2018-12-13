package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.SaveCustomers;
import Controller.CommandFactory.CommandFactory;
import Controller.StreamService;
import Model.CustomerDB;

/**
 * This class create new SaveCustomer command
 */
public class SaveCustomersFactory implements CommandFactory {
    private CustomerDB db;
    private StreamService service;

    public SaveCustomersFactory(CustomerDB db, StreamService service){
        this.db = db;
        this.service = service;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.SaveCustomers
     */
    @Override
    public Command createCommand(){
        return new SaveCustomers(db, service);
    }

    public CustomerDB getDb() {
        return db;
    }
}
