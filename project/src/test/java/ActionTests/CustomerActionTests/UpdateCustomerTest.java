package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.UpdateCustomer;
import Controller.Exceptions.CustomerNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
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
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        db = new CustomerDB();
        db.addCustomer(customer);
    }

    @Test
    public void testExecute(){
        map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "Ivan");
        map.put("phone", "+12345678901");
        map.put("address", "Russia");

        try{
            UpdateCustomer uc = new UpdateCustomer(db);
            uc.execute(map);

            Assert.assertEquals(1, db.getCustomers().size());

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
            UpdateCustomer uc = new UpdateCustomer(db);
            uc.execute(map);
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
        map.put("i d", "1");

        try{
            UpdateCustomer uc = new UpdateCustomer(db);
            uc.execute(map);
        }
        catch (WrongParameterException e){
            Assert.assertEquals("Wrong Parameter", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomerNotFoundException(){
        map = new HashMap<>();
        map.put("id", "2");

        try{
            UpdateCustomer uc = new UpdateCustomer(db);
            uc.execute(map);
        }
        catch (CustomerNotFoundException e){
            Assert.assertEquals("Customer not found", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

