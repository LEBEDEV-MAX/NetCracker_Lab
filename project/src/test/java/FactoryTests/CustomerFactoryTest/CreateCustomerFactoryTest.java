package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.CommandFactory.CustomerFactories.CreateCustomerFactory;
import Controller.Actions.CustomerActions.CreateCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CreateCustomerFactoryTest {
    private CustomerDB db;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
    }

    @Test
    public void test(){
        CreateCustomerFactory factory = new CreateCustomerFactory(db);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof CreateCustomer);
    }
}
