package FactoryTests.OrderFactoryTests;

import Controller.Command;
import Controller.CommandFactory.OrderFactories.DeleteOrderFactory;
import Controller.OrderActions.DeleteOrder;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteOrderFactoryTest {
    private OrderDB db;
    private DeleteOrderFactory factory;

    @Before
    public void beforeTest(){
        db = new OrderDB();
        factory = new DeleteOrderFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof DeleteOrder);
    }
}
