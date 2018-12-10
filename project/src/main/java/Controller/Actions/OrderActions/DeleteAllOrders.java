package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Model.OrderDB;

import java.util.Map;

public class DeleteAllOrders implements Command {
    private OrderDB db;

    public DeleteAllOrders(OrderDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        db.deleteAllOrders();
    }
}
