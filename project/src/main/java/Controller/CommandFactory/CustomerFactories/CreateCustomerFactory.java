package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.CreateCustomer;
import Model.CustomerDB;


public class CreateCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public CreateCustomerFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new CreateCustomer(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
