package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.CreateCustomer;
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

    @Test
    public void testWrongArgumentException(){
        map = new HashMap<>();
        map.put("id", "a");

        try{
            CreateCustomer create = new CreateCustomer(db);
            create.execute(map);
        }
        catch (WrongArgumentException e){
            Assert.assertEquals("Wrong Argument", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testWrongParameterException(){
        map = new HashMap<>();
        map.put("i d", "a");

        try{
            CreateCustomer create = new CreateCustomer(db);
            create.execute(map);
        }
        catch (WrongParameterException e){
            Assert.assertEquals("Wrong Parameter", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
