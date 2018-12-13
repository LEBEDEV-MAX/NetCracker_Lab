package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.LoadCustomers;
import Controller.Actions.CustomerActions.SaveCustomers;
import Controller.Exceptions.WrongArgumentException;
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

public class LoadCustomersTest {
    private CustomerDB db;
    private Map<String, String> mapLoad;
    private Customer customer;
    private Customer customer1;
    private File file;
    private StreamService service;

    @Before
    public void beforeTest(){
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        customer1 = new Customer(1, "Ivan", "+01234567890", "Russia");
        db = new CustomerDB();
        db.addCustomer(customer1);

        file = new File("Customers.dat");
        service = new StreamService();

        Map<String, String> mapSave = new HashMap<>();
        mapSave.put("file", "Customers.dat");

        try{
            SaveCustomers sc = new SaveCustomers(db, service);
            sc.execute(mapSave);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        db.deleteAllCustomers();
        db.addCustomer(customer);
    }

    @Test
    public void testExecuteWithReplace(){
        mapLoad = new HashMap<>();
        mapLoad.put("file", "Customers.dat");
        mapLoad.put("dublicatePolicy", "replace");

        try{
            LoadCustomers lc = new LoadCustomers(db, service);
            lc.execute(mapLoad);

            Assert.assertEquals(1, db.getCustomers().size());

            Customer c = db.getCustomer(1);
            Assert.assertEquals(customer1.getId(), c.getId());
            Assert.assertEquals(customer1.getName(), c.getName());
            Assert.assertEquals(customer1.getPhone(), c.getPhone());
            Assert.assertEquals(customer1.getAddress(), c.getAddress());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testExecuteWithSkip(){
        mapLoad = new HashMap<>();
        mapLoad.put("file", "Customers.dat");
        mapLoad.put("dublicatePolicy", "skip");

        try{
            LoadCustomers lc = new LoadCustomers(db, service);
            lc.execute(mapLoad);

            Assert.assertEquals(1, db.getCustomers().size());

            Customer c = db.getCustomer(1);
            Assert.assertEquals(customer.getId(), c.getId());
            Assert.assertEquals(customer.getName(), c.getName());
            Assert.assertEquals(customer.getPhone(), c.getPhone());
            Assert.assertEquals(customer.getAddress(), c.getAddress());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(expected = WrongParameterException.class)
    public void testWrongParameterException() throws Exception{
        mapLoad = new HashMap<>();
        mapLoad.put("fi le", "Customers.dat");
        mapLoad.put("dublicatePolicy", "a");

        LoadCustomers lc = new LoadCustomers(db, service);
        lc.execute(mapLoad);
    }

    @Test(expected = WrongArgumentException.class)
    public void testWrongArgumentException() throws Exception{
        mapLoad = new HashMap<>();
        mapLoad.put("file", "Customers.dat");
        mapLoad.put("dublicatePolicy", "a");

        LoadCustomers lc = new LoadCustomers(db, service);
        lc.execute(mapLoad);
    }

    @After
    public void afterTest(){
        if(!file.delete()) System.out.println("file not deleted");
    }
}
