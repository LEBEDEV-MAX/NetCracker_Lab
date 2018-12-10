package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.GetAllCustomers;
import Model.Customer;
import Model.CustomerDB;
import View.PrintAllCustomers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class GetAllCustomersTest {
    private CustomerDB db;
    private Customer customer;
    private PrintAllCustomers pac;
    private Map<String, String> map;

    @Before
    public void beforeTest(){
        customer = new Customer(1, "Igor", "+09876543210", "USA");

        db = new CustomerDB();
        db.addCustomer(customer);

        pac = new PrintAllCustomers();
        map = new HashMap<>();
    }

    @Test
    public void test(){
        GetAllCustomers gac = new GetAllCustomers(db, pac);
        gac.execute(map);

        Assert.assertEquals(db, gac.getDb());
    }
}
