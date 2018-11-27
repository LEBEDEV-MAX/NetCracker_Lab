package FactoryTests.CustomerFactoryTest;

import Controller.Command;
import Controller.CommandFactory.CustomerFactories.GetCustomerFactory;
import Controller.CustomerActions.GetCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetGuctomerFactoryTest {
    private CustomerDB db;
    private GetCustomerFactory factory;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        factory = new GetCustomerFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof GetCustomer);
    }
}
