package FactoryTests.OrderFactoryTests;

import Controller.Command;
import Controller.CommandFactory.OrderFactories.UpdateOrderFactory;
import Controller.OrderActions.UpdateOrder;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UpdateOrderFactoryTest {
    private OrderDB db;
    private UpdateOrderFactory factory;

    @Before
    public void beforeTest(){
        db = new OrderDB();
        factory = new UpdateOrderFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof UpdateOrder);
    }
}
