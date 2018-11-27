package ActionTests.CustomerActionTests;

import Controller.CustomerActions.GetCustomer;
import Model.Customer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GetCustomerTest {
    private CustomerDB db;
    private Customer customer;
    private Map<String, String> map;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        db.addCustomer(customer);
        map = new HashMap<>();
        map.put("id=", "1");
    }

    @Test
    public void test(){
        GetCustomer gc = new GetCustomer(db);

        Assert.assertEquals(customer, gc.getCustomerByID(map));
    }
}
