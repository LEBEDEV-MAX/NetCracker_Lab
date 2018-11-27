package FactoryTests.CustomerFactoryTest;

import Controller.Command;
import Controller.CommandFactory.CustomerFactories.GetAllCustomersFactory;
import Controller.CustomerActions.GetAllCustomers;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GetAllCustomersFactoryTest {
    private CustomerDB db;
    private GetAllCustomersFactory factory;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        factory = new GetAllCustomersFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof GetAllCustomers);
    }
}
