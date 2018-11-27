package Controller.CommandFactory.CustomerFactories;

import Controller.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.CustomerActions.GetAllCustomers;
import Model.CustomerDB;


public class GetAllCustomersFactory implements CommandFactory {
    private CustomerDB db;

    public GetAllCustomersFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new GetAllCustomers(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
