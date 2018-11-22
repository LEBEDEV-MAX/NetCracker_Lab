import Controller.CustomerActions.CreateCustomer;
import Model.Customer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateCustomerTest {
    private CustomerDB db;
    private Map<String, String> map;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        map = new HashMap<>();
        map.put("id=", "1");
        map.put("name=", "Ivan");
        map.put("phone=", "+12345678901");
        map.put("address=", "Russia");
    }

    @Test
    public void test(){
        CreateCustomer create = new CreateCustomer(db);
        create.execute(map);

        Assert.assertEquals(1, db.getCustomers().size());
        Customer customer = db.getCustomer(0);

        Assert.assertEquals(1, customer.getId());
        Assert.assertEquals("Ivan", customer.getName());
        Assert.assertEquals("+12345678901", customer.getPhone());
        Assert.assertEquals("Russia", customer.getAddress());
    }

}
