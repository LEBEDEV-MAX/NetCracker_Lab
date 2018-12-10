package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.SaveCustomers;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SaveCustomersTest {
    private CustomerDB db;
    private Map<String, String> map;
    private Customer customer;

    @Before
    public void beforTest(){
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        db = new CustomerDB();
        db.addCustomer(customer);
    }

    @Test
    public void testExecute(){
        map = new HashMap<>();
        map.put("file", "Customers.dat");
        File file = new File("Customers.dat");

        try{
            SaveCustomers sc = new SaveCustomers(db);
            sc.execute(map);

            Assert.assertTrue(file.exists());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(!file.delete()) System.out.println("file not deleted");
        }
    }

    @Test
    public void testWrongParameterException(){
        map = new HashMap<>();
        map.put("fi le", "Customers.dat");

        try{
            SaveCustomers sc = new SaveCustomers(db);
            sc.execute(map);
        }
        catch (WrongParameterException e){
            Assert.assertEquals("Wrong Parameter", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
