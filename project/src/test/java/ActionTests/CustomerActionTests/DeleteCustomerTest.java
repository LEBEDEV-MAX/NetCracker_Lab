package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.DeleteCustomer;
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

public class DeleteCustomerTest {
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

        try{
            DeleteCustomer dc = new DeleteCustomer(db);
            dc.execute(map);

            Assert.assertEquals(0, db.getCustomers().size());
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
            DeleteCustomer dc = new DeleteCustomer(db);
            dc.execute(map);
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
            DeleteCustomer dc = new DeleteCustomer(db);
            dc.execute(map);
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
            DeleteCustomer dc = new DeleteCustomer(db);
            dc.execute(map);
        }
        catch (CustomerNotFoundException e){
            Assert.assertEquals("Customer not found", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
