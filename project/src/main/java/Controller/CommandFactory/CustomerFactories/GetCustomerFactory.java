package Controller.CommandFactory.CustomerFactories;

import Controller.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.CustomerActions.GetCustomer;
import Model.CustomerDB;

public class GetCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public GetCustomerFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new GetCustomer(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
