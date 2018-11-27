package FactoryTests.CustomerFactoryTest;

import Controller.Command;
import Controller.CommandFactory.CustomerFactories.UpdateCustomerFactory;
import Controller.CustomerActions.UpdateCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UpdateCustomerFactoryTest {
    private CustomerDB db;
    private UpdateCustomerFactory factory;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        factory = new UpdateCustomerFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof UpdateCustomer);
    }
}
