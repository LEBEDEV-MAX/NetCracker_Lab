package Controller.CommandFactory.OrderFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.OrderActions.GetAllOrders;
import Model.OrderDB;
import View.OrdersView.PrintAllOrders;

public class GetAllOrdersFactory implements CommandFactory {
    private OrderDB db;
    private PrintAllOrders pao;

    public GetAllOrdersFactory(OrderDB db, PrintAllOrders pao){
        this.db = db;
        this.pao = pao;
    }

    @Override
    public Command createCommand(){
        return new GetAllOrders(db, pao);
    }

    public OrderDB getDb() {
        return db;
    }
}
