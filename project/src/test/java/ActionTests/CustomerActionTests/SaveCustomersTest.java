package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.SaveCustomers;
import Controller.Exceptions.WrongParameterException;
import Controller.StreamService;
import Model.Customer;
import Model.CustomerDB;
import org.junit.After;
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
    private StreamService service;
    private File file;

    @Before
    public void beforeTest(){
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        db = new CustomerDB();
        db.addCustomer(customer);
        service = new StreamService();
        file = new File("Customers.dat");
    }

    @Test
    public void testExecute(){
        map = new HashMap<>();
        map.put("file", "Customers.dat");

        try{
            SaveCustomers sc = new SaveCustomers(db, service);

            sc.execute(map);

            Assert.assertTrue(file.exists());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(expected = WrongParameterException.class)
    public void testWrongParameterException() throws Exception{
        map = new HashMap<>();
        map.put("fi le", "Customers.dat");

        SaveCustomers sc = new SaveCustomers(db, service);
        sc.execute(map);
    }


    @After
    public void afterTest(){
        if(!file.delete()) System.out.println("file not deleted");
    }
}
