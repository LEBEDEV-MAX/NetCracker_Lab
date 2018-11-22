package Controller.CustomerActions;

import Controller.Command;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

public class CreateCustomer implements Command {
    private Map<String, String> map;
    private CustomerDB db;

    public CreateCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        this.map = map;
        Customer customer = new Customer(
                Integer.parseInt(map.get("id=")),
                map.get("name="),
                map.get("phone="),
                map.get("address=")
        );
        db.addCustomer(customer);
    }

    public Map<String, String> getMap() {
        return map;
    }
}
