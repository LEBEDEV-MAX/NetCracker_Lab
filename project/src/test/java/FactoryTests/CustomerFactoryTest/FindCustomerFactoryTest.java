package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.FindCustomer;
import Controller.CommandFactory.CustomerFactories.FindCustomerFactory;
import Model.CustomerDB;
import View.PrintFoundCustomer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindCustomerFactoryTest {
    private CustomerDB db;
    private PrintFoundCustomer pfc;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        pfc = new PrintFoundCustomer();
    }

    @Test
    public void test(){
        FindCustomerFactory factory = new FindCustomerFactory(db, pfc);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof FindCustomer);
    }
}
