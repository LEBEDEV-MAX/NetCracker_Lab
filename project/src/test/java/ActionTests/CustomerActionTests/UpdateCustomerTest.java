package ActionTests.CustomerActionTests;

import Controller.CustomerActions.UpdateCustomer;
import Model.Customer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateCustomerTest {
    private CustomerDB db;
    private Map<String, String> map;
    private Customer customer;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        db.addCustomer(customer);
        map = new HashMap<>();
        map.put("id=", "1");
        map.put("name=", "Ivan");
        map.put("phone=", "+12345678901");
        map.put("address=", "Russia");
    }

    @Test
    public void test(){
        UpdateCustomer uc = new UpdateCustomer(db);
        uc.execute(map);

        Assert.assertEquals(1, db.getCustomers().size());

        Assert.assertEquals(1, customer.getId());
        Assert.assertEquals("Ivan", customer.getName());
        Assert.assertEquals("+12345678901", customer.getPhone());
        Assert.assertEquals("Russia", customer.getAddress());
    }
}

