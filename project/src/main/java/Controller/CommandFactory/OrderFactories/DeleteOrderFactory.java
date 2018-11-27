package Controller.CommandFactory.OrderFactories;

import Controller.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.OrderActions.DeleteOrder;
import Model.OrderDB;

public class DeleteOrderFactory implements CommandFactory {
    private OrderDB db;

    public DeleteOrderFactory(OrderDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new DeleteOrder(db);
    }

    public OrderDB getDb() {
        return db;
    }
}
