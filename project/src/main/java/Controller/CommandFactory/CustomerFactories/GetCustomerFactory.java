package Controller.CommandFactory.CustomerFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.CustomerActions.GetCustomer;
import Model.CustomerDB;
import View.CustomersView.PrintCustomer;

/**
 * This class create new GetCustomer command
 */
public class GetCustomerFactory implements CommandFactory {
    private CustomerDB db;
    private PrintCustomer pc;

    public GetCustomerFactory(CustomerDB db, PrintCustomer pc){
        this.db = db;
        this.pc = pc;
    }

    /**
     * @see Controller.CommandFactory.CommandFactory
     * @return Command
     * @see Controller.Actions.CustomerActions.GetCustomer
     * */
    @Override
    public Command createCommand(){
        return new GetCustomer(db, pc);
    }

    public CustomerDB getDb() {
        return db;
    }
}
