package FactoryTests.OrderFactoryTests;

import Controller.Command;
import Controller.CommandFactory.OrderFactories.GetOrderFactory;
import Controller.OrderActions.GetOrder;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetOrderFactoryTest {
    private OrderDB db;
    private GetOrderFactory factory;

    @Before
    public void beforeTest(){
        db = new OrderDB();
        factory = new GetOrderFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof GetOrder);
    }
}
