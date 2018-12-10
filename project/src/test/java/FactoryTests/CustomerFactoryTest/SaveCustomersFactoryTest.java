package FactoryTests.CustomerFactoryTest;

import Controller.Actions.Command;
import Controller.Actions.CustomerActions.SaveCustomers;
import Controller.CommandFactory.CustomerFactories.SaveCustomersFactory;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SaveCustomersFactoryTest {
    private CustomerDB db;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
    }

    @Test
    public void test(){
        SaveCustomersFactory factory = new SaveCustomersFactory(db);
        Command cmd = factory.createCommand();

        Assert.assertEquals(db, factory.getDb());
        Assert.assertTrue(cmd instanceof SaveCustomers);
    }
}
