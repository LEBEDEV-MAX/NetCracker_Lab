package Controller.OrderActions;

import Controller.Command;
import Model.Order;
import Model.OrderDB;

import java.util.Map;

public class GetOrder implements Command {
    private OrderDB db;

    public GetOrder(OrderDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        Order order = getOrderByID(map);
        /**/

    }

    public Order getOrderByID(Map<String, String> map){
        if(map.get("id=") != null){
            int index = Integer.parseInt(map.get("orderID=")); // прописать try catch
            return db.getOrder(index);
        }
        else{
            return null;
            //ошбика не найден айдишник где менять
        }
    }
}
