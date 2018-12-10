package Controller.CommandFactory.OrderFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.OrderActions.UpdateOrder;
import Model.OrderDB;

public class UpdateOrderFactory implements CommandFactory {
    private OrderDB db;

    public UpdateOrderFactory(OrderDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new UpdateOrder(db);
    }

    public OrderDB getDb() {
        return db;
    }
}
