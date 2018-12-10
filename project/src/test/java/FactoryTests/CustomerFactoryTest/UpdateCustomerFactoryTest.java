package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.CommandFactory.CustomerFactories.UpdateCustomerFactory;
import Controller.Actions.CustomerActions.UpdateCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UpdateCustomerFactoryTest {
    private CustomerDB db;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
    }

    @Test
    public void test(){
        UpdateCustomerFactory factory = new UpdateCustomerFactory(db);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof UpdateCustomer);
    }
}
