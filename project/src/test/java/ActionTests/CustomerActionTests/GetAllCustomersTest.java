package ActionTests.CustomerActionTests;

import Controller.CustomerActions.GetAllCustomers;
import Model.Customer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GetAllCustomersTest {
    private CustomerDB db;
    private Customer customer;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        db.addCustomer(customer);
    }

    @Test
    public void test(){
        GetAllCustomers gac = new GetAllCustomers(db);

        Assert.assertEquals(db, gac.getDb());
    }
}
