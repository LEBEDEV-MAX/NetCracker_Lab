package Controller.CustomerActions;

import Controller.Command;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

public class GetCustomer implements Command {
    private CustomerDB db;

    public GetCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        Customer customer = getCustomerByID(map);
        /**/

    }

    public Customer getCustomerByID(Map<String, String> map){
        if(map.get("id=") != null){
            int index = Integer.parseInt(map.get("id=")); // прописать try catch
            return db.getCustomer(index);
        }
        else{
            return null;
            //ошбика не найден айдишник где менять
        }
    }
}
