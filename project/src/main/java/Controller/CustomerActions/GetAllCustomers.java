package Controller.CustomerActions;

import Controller.Command;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

public class GetAllCustomers implements Command {
    private CustomerDB db;

    public GetAllCustomers(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){

    }

    public CustomerDB getDb(){
        return db;
    }
}
