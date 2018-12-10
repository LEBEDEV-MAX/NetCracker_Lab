package FactoryTests.OrderFactoryTests;

import Controller.Actions.Command;
import Controller.CommandFactory.OrderFactories.DeleteAllOrdersFactory;
import Controller.Actions.OrderActions.DeleteAllOrders;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteAllOrdersFactoryTest {
    private OrderDB db;
    private DeleteAllOrdersFactory factory;

    @Before
    public void beforeTest(){
        db = new OrderDB();
        factory = new DeleteAllOrdersFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof DeleteAllOrders);
    }
}
