package Controller.CustomerActions;

import Controller.Command;
import Model.Customer;
import Model.CustomerDB;

import java.util.Map;

public class UpdateCustomer implements Command{
    private CustomerDB db;

    public UpdateCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        if(map.get("id=") != null){
            int index = Integer.parseInt(map.get("id="));  // прописать try catch
            Customer customer = db.getCustomer(index);

            if(customer != null){
                if(map.get("name=") != null)
                    customer.setName(map.get("name="));
                if(map.get("phone=") != null)
                    customer.setPhone(map.get("phone="));
                if(map.get("address=") != null)
                    customer.setAddress(map.get("address="));
            }
        }
        else{
            //ошбика не найден айдишник где менять
        }
    }
}
