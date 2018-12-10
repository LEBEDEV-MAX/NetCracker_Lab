package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.FindCustomer;
import Controller.CommandFactory.CommandFactory;
import Model.CustomerDB;
import View.PrintFoundCustomer;

public class FindCustomerFactory implements CommandFactory{
    private CustomerDB db;
    private PrintFoundCustomer pfc;

    public FindCustomerFactory(CustomerDB db, PrintFoundCustomer pfc){
        this.db = db;
        this.pfc = pfc;
    }

    @Override
    public Command createCommand(){
        return new FindCustomer(db, pfc);
    }

    public CustomerDB getDb() {
        return db;
    }
}
