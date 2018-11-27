package FactoryTests.CustomerFactoryTest;

import Controller.Command;
import Controller.CommandFactory.CustomerFactories.DeleteCustomerFactory;
import Controller.CustomerActions.DeleteCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteCustomerFactoryTest {
    private CustomerDB db;
    private DeleteCustomerFactory factory;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        factory = new DeleteCustomerFactory(db);
    }

    @Test
    public void test(){
        Command cmd = factory.createCommand();
        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof DeleteCustomer);
    }
}
