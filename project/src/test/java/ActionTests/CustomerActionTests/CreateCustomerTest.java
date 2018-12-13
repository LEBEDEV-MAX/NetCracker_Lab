package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.CreateCustomer;
import Controller.Exceptions.ExistCustomerException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
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
    }

    @Test
    public void testExecute(){
        map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "Ivan");
        map.put("phone", "+12345678901");
        map.put("address", "Russia");


        try{
            CreateCustomer create = new CreateCustomer(db);
            create.execute(map);

            Assert.assertEquals(1, db.getCustomers().size());

            Customer customer = db.getCustomer(1);

            Assert.assertEquals(1, customer.getId());
            Assert.assertEquals("Ivan", customer.getName());
            Assert.assertEquals("+12345678901", customer.getPhone());
            Assert.assertEquals("Russia", customer.getAddress());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(expected = WrongArgumentException.class)
    public void testWrongArgumentException() throws Exception{
        map = new HashMap<>();
        map.put("id", "a");

        CreateCustomer create = new CreateCustomer(db);
        create.execute(map);

    }

    @Test(expected = WrongParameterException.class)
    public void testWrongParameterException() throws Exception{
        map = new HashMap<>();
        map.put("i d", "1");

        CreateCustomer create = new CreateCustomer(db);
        create.execute(map);
    }

    @Test(expected = ExistCustomerException.class)
    public void testExistCustomerException() throws Exception{
        map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "Ivan");
        map.put("phone", "+12345678901");
        map.put("address", "Russia");

        CreateCustomer create = new CreateCustomer(db);
        create.execute(map);
        create.execute(map);
    }
}
