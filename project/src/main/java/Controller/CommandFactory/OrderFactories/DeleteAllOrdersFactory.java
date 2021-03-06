package Controller.CommandFactory.OrderFactories;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.Actions.OrderActions.DeleteAllOrders;
import Model.OrderDB;

public class DeleteAllOrdersFactory implements CommandFactory {
    private OrderDB db;

    public DeleteAllOrdersFactory(OrderDB db){
        this.db = db;
    }

    @Override
    public Command createCommand(){
        return new DeleteAllOrders(db);
    }

    public OrderDB getDb() {
        return db;
    }
}
