package Controller.CommandFactory.CustomerFactories;

import Controller.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.CustomerActions.UpdateCustomer;
import Model.CustomerDB;

public class UpdateCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public UpdateCustomerFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new UpdateCustomer(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
