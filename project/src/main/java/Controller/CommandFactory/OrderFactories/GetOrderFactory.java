package Controller.CommandFactory.OrderFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.OrderActions.GetOrder;
import Model.OrderDB;

public class GetOrderFactory implements CommandFactory {
    private OrderDB db;

    public GetOrderFactory(OrderDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new GetOrder(db);
    }

    public OrderDB getDb() {
        return db;
    }
}
