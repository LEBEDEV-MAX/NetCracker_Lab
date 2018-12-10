package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.GetCustomer;
import Controller.Exceptions.CustomerNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;
import View.PrintCustomer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GetCustomerTest {
    private CustomerDB db;
    private Customer customer;
    private Map<String, String> map;
    private PrintCustomer pc;

    @Before
    public void beforeTest(){
        customer = new Customer(1, "Igor", "+09876543210", "USA");

        db = new CustomerDB();
        db.addCustomer(customer);

        pc = new PrintCustomer();
    }

    @Test
    public void testExecute(){
        map = new HashMap<>();
        map.put("id", "1");

        try{
            GetCustomer gc = new GetCustomer(db, pc);
            gc.execute(map);

            Assert.assertEquals(db, gc.getDB());
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
            GetCustomer gc = new GetCustomer(db, pc);
            gc.execute(map);
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
            GetCustomer gc = new GetCustomer(db, pc);
            gc.execute(map);
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
            GetCustomer gc = new GetCustomer(db, pc);
            gc.execute(map);
        }
        catch (CustomerNotFoundException e){
            Assert.assertEquals("Customer not found", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
