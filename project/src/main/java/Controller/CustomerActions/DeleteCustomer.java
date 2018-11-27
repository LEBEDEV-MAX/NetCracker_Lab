package Controller.CustomerActions;

import Controller.Command;
import Model.CustomerDB;

import java.util.Map;

public class DeleteCustomer implements Command{
    private CustomerDB db;

    public DeleteCustomer(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        if (map.get("id=") != null){
            int index = Integer.parseInt(map.get("id=")); // прописать try catch
            db.deleteCustomer(index);
        }
        else{
            //ошбика не найден айдишник кого удалять
        }
    }
}
