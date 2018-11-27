package FactoryTests.CustomerFactoryTest;

import Controller.Command;
import Controller.CommandFactory.CustomerFactories.CreateCustomerFactory;
import Controller.CustomerActions.CreateCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CreateCustomerFactoryTest {
    private CustomerDB db;
    private CreateCustomerFactory factory;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        factory = new CreateCustomerFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof CreateCustomer);
    }
}
