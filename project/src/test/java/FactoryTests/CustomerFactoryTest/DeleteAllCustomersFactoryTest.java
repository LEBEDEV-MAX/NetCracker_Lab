package FactoryTests.CustomerFactoryTest;

import Controller.Command;
import Controller.CommandFactory.CustomerFactories.DeleteAllCustomerFactory;
import Controller.CustomerActions.DeleteCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteAllCustomersFactoryTest {
    private CustomerDB db;
    private DeleteAllCustomerFactory factory;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        factory = new DeleteAllCustomerFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof DeleteCustomer);
    }
}
