package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.LoadCustomers;
import Controller.CommandFactory.CommandFactory;
import Model.CustomerDB;

public class LoadCustomersFactory implements CommandFactory {
    private CustomerDB db;

    public LoadCustomersFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new LoadCustomers(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
