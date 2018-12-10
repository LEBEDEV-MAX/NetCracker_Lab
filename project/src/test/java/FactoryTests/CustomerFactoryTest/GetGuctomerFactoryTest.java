package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.CommandFactory.CustomerFactories.GetCustomerFactory;
import Controller.Actions.CustomerActions.GetCustomer;
import Model.CustomerDB;
import View.PrintCustomer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetGuctomerFactoryTest {
    private CustomerDB db;
    private PrintCustomer pc;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        pc = new PrintCustomer();
    }

    @Test
    public void test(){
        GetCustomerFactory factory = new GetCustomerFactory(db, pc);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof GetCustomer);
    }
}
