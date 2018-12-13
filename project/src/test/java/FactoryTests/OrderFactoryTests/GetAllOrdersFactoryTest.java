package FactoryTests.OrderFactoryTests;

import Controller.Actions.Command;
import Controller.CommandFactory.OrderFactories.GetAllOrdersFactory;
import Controller.Actions.OrderActions.GetAllOrders;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetAllOrdersFactoryTest {
    /*private OrderDB db;
    private GetAllOrdersFactory factory;

    @Before
    public void beforeTest(){
        db = new OrderDB();
        factory = new GetAllOrdersFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof GetAllOrders);
    }*/
}
