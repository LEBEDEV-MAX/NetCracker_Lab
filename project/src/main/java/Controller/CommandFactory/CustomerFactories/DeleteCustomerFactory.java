package Controller.CommandFactory.CustomerFactories;

import Controller.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.CustomerActions.DeleteCustomer;
import Model.CustomerDB;

public class DeleteCustomerFactory implements CommandFactory {
    private CustomerDB db;

    public DeleteCustomerFactory(CustomerDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new DeleteCustomer(db);
    }

    public CustomerDB getDb() {
        return db;
    }
}
