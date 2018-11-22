package Controller.CommandFactory;

import Controller.Command;
import Controller.CustomerActions.CreateCustomer;
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
