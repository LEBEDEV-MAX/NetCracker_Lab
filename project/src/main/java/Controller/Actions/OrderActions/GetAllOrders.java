package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Model.OrderDB;
import View.OrdersView.PrintAllOrders;

import java.util.Map;

public class GetAllOrders implements Command {
    private OrderDB db;
    private PrintAllOrders pao;

    public GetAllOrders(OrderDB db, PrintAllOrders pao){
        this.db = db;
        this.pao = pao;
    }

    @Override
    public void execute(Map<String, String> map){
        pao.print(db);
    }

    public OrderDB getDb(){
        return db;
    }
}
