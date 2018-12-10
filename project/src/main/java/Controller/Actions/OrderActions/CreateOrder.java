package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Model.Order;
import Model.OrderDB;

import java.util.Map;

public class CreateOrder implements Command {
    private OrderDB orderDB;

    public CreateOrder(OrderDB orderDB){
        this.orderDB = orderDB;
    }

    @Override
    public void execute(Map<String, String> map){
        Order order = new Order(
                Integer.parseInt(map.get("customerID=")),
                Integer.parseInt(map.get("orderID=")),
                map.get("date="),
                Integer.parseInt(map.get("sum="))
        );
        orderDB.addOrder(order);
    }
}
