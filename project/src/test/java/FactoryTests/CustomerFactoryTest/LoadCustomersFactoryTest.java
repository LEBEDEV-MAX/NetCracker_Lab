package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.LoadCustomers;
import Controller.CommandFactory.CustomerFactories.LoadCustomersFactory;
import Controller.StreamService;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoadCustomersFactoryTest {
    private CustomerDB db;
    private StreamService service;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        service = new StreamService();
    }

    @Test
    public void test(){
        LoadCustomersFactory factory = new LoadCustomersFactory(db, service);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof LoadCustomers);
    }
}
