package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.LoadCustomers;
import Controller.CommandFactory.CommandFactory;
import Controller.StreamService;
import Model.CustomerDB;

/**
 * This class create new LoadCustomers command
 */
public class LoadCustomersFactory implements CommandFactory {
    private CustomerDB db;
    private StreamService service;

    public LoadCustomersFactory(CustomerDB db, StreamService service){
        this.db = db;
        this.service = service;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.LoadCustomers
     */
    @Override
    public Command createCommand(){
        return new LoadCustomers(db, service);
    }

    public CustomerDB getDb() {
        return db;
    }
}
