package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Model.OrderDB;

import java.util.Map;

public class GetAllOrders implements Command {
    private OrderDB db;

    public GetAllOrders(OrderDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){

    }

    public OrderDB getDb(){
        return db;
    }
}
