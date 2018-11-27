package Controller.CommandFactory.OrderFactories;

import Controller.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.OrderActions.GetAllOrders;
import Model.OrderDB;

public class GetAllOrdersFactory implements CommandFactory {
    private OrderDB db;

    public GetAllOrdersFactory(OrderDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new GetAllOrders(db);
    }

    public OrderDB getDb() {
        return db;
    }
}
