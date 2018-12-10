package Controller.CommandFactory.OrderFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.OrderActions.CreateOrder;
import Model.OrderDB;

public class CreateOrderFactory implements CommandFactory {
    private OrderDB db;

    public CreateOrderFactory(OrderDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new CreateOrder(db);
    }

    public OrderDB getDb() {
        return db;
    }
}
