package ActionTests.CustomerActionTests;

import Controller.CustomerActions.DeleteCustomer;
import Model.Customer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DeleteCustomerTest {
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
    }

    @Test
    public void test(){
        DeleteCustomer dc = new DeleteCustomer(db);
        dc.execute(map);

        Assert.assertEquals(0, db.getCustomers().size());
    }
}
