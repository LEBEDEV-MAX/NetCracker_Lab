package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.DeleteAllCustomers;
import Model.Customer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DeleteAllCustomersTest {
    private CustomerDB db;
    private Map<String, String> map;
    private Customer customer;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        db.addCustomer(customer);
        map = new HashMap<>();
    }

    @Test
    public void test(){
        DeleteAllCustomers dc = new DeleteAllCustomers(db);
        dc.execute(map);

        Assert.assertEquals(0, db.getCustomers().size());
    }
}
