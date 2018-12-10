package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.GetAllCustomers;
import Model.CustomerDB;
import View.PrintAllCustomers;


public class GetAllCustomersFactory implements CommandFactory {
    private CustomerDB db;
    private PrintAllCustomers pac;

    public GetAllCustomersFactory(CustomerDB db, PrintAllCustomers pac){
        this.db = db;
        this.pac = pac;
    }

    @Override
    public Command createCommand(){
        return new GetAllCustomers(db, pac);
    }

    public CustomerDB getDb() {
        return db;
    }
}
