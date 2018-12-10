package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.CommandFactory.CustomerFactories.GetAllCustomersFactory;
import Controller.Actions.CustomerActions.GetAllCustomers;
import Model.CustomerDB;
import View.PrintAllCustomers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GetAllCustomersFactoryTest {
    private CustomerDB db;
    private PrintAllCustomers pac;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        pac = new PrintAllCustomers();
    }

    @Test
    public void test(){
        GetAllCustomersFactory factory = new GetAllCustomersFactory(db, pac);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof GetAllCustomers);
    }
}
