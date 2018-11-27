package FactoryTests.OrderFactoryTests;

import Controller.Command;
import Controller.CommandFactory.OrderFactories.CreateOrderFactory;
import Controller.OrderActions.CreateOrder;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateOrderFactoryTest {
    private OrderDB db;
    private CreateOrderFactory factory;

    @Before
    public void beforeTest(){
        db = new OrderDB();
        factory = new CreateOrderFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof CreateOrder);
    }
}
