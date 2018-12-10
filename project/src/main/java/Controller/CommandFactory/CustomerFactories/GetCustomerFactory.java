package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.GetCustomer;
import Model.CustomerDB;
import View.PrintCustomer;

public class GetCustomerFactory implements CommandFactory {
    private CustomerDB db;
    private PrintCustomer pc;

    public GetCustomerFactory(CustomerDB db, PrintCustomer pc){
        this.db = db;
        this.pc = pc;
    }

    @Override
    public Command createCommand(){
        return new GetCustomer(db, pc);
    }

    public CustomerDB getDb() {
        return db;
    }
}
