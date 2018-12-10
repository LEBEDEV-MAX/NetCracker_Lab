package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.LoadCustomers;
import Controller.CommandFactory.CustomerFactories.LoadCustomersFactory;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoadCustomersFactoryTest {
    private CustomerDB db;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
    }

    @Test
    public void test(){
        LoadCustomersFactory factory = new LoadCustomersFactory(db);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof LoadCustomers);
    }
}
