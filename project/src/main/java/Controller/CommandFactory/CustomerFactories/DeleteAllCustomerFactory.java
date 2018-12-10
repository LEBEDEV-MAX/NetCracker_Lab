package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.DeleteAllCustomers;
import Model.CustomerDB;

public class DeleteAllCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public DeleteAllCustomerFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new DeleteAllCustomers(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
