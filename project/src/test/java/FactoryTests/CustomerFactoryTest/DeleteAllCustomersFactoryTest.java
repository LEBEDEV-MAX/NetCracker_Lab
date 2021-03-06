package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.CommandFactory.CustomerFactories.DeleteAllCustomerFactory;
import Controller.Actions.CustomerActions.DeleteAllCustomers;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteAllCustomersFactoryTest {
    private CustomerDB db;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
    }

    @Test
    public void test(){
        DeleteAllCustomerFactory factory = new DeleteAllCustomerFactory(db);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof DeleteAllCustomers);
    }
}
