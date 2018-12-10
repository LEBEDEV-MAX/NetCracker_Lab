package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.CommandFactory.CustomerFactories.DeleteCustomerFactory;
import Controller.Actions.CustomerActions.DeleteCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteCustomerFactoryTest {
    private CustomerDB db;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
    }

    @Test
    public void test(){
        DeleteCustomerFactory factory = new DeleteCustomerFactory(db);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof DeleteCustomer);
    }
}
