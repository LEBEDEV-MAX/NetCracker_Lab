package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.SaveCustomers;
import Controller.CommandFactory.CommandFactory;
import Model.CustomerDB;

public class SaveCustomersFactory implements CommandFactory {
    private CustomerDB db;

    public SaveCustomersFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new SaveCustomers(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
