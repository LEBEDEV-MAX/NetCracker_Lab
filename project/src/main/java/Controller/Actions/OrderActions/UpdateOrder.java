package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Model.Order;
import Model.OrderDB;

import java.util.Map;

public class UpdateOrder implements Command{
    private OrderDB db;

    public UpdateOrder(OrderDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        if(map.get("orderID=") != null){
            int index = Integer.parseInt(map.get("orderID="));  // прописать try catch
            Order order = db.getOrder(index);

            if(order != null){
                if(map.get("customerID=") != null){
                    int customerid = Integer.parseInt(map.get("customerID=")); // прописать try catch
                    order.setCustomerID(customerid);
                }
                if(map.get("date=") != null)
                    order.setDate(map.get("date="));
                if(map.get("sum=") != null){
                    int sum = Integer.parseInt(map.get("sum=")); // прописать try catch
                    order.setSum(sum);
                }
            }
        }
        else{
            //ошбика не найден айдишник где менять
        }
    }
}
