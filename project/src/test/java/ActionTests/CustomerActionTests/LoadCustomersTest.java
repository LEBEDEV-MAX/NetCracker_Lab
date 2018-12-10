package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.LoadCustomers;
import Controller.Actions.CustomerActions.SaveCustomers;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;
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

    @Before
    public void beforeTest(){
        customer = new Customer(1, "Igor", "+09876543210", "USA");
        customer1 = new Customer(1, "Ivan", "+1234567890", "Russia");
        db = new CustomerDB();
        db.addCustomer(customer);
        db.addCustomer(customer1);

        file = new File("Customers.dat");

        Map<String, String> mapSave = new HashMap<>();
        mapSave.put("file", "Customers.dat");

        try{
            SaveCustomers sc = new SaveCustomers(db);
            sc.execute(mapSave);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testExecuteWithReplace(){
        mapLoad = new HashMap<>();
        mapLoad.put("file", "Customers.dat");
        mapLoad.put("dublicatePolicy", "replace");

        try{
            LoadCustomers lc = new LoadCustomers(db);
            //db.getCustomers().clear();
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
        finally {
            if(!file.delete()) System.out.println("file not deleted");
        }

    }

    @Test
    public void testExecuteWithSkip(){
        mapLoad = new HashMap<>();
        mapLoad.put("file", "Customers.dat");
        mapLoad.put("dublicatePolicy", "skip");

        try{
            LoadCustomers lc = new LoadCustomers(db);
            //db.getCustomers().clear();
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
        finally {
            if(!file.delete()) System.out.println("file not deleted");
        }
    }

    @Test
    public void testWrongParameterException(){
        mapLoad = new HashMap<>();
        mapLoad.put("fi le", "Customers.dat");
        mapLoad.put("dublicatePolicy", "a");

        try{
            LoadCustomers lc = new LoadCustomers(db);
            lc.execute(mapLoad);
        }
        catch (WrongParameterException e){
            Assert.assertEquals("Wrong Parameter", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(!file.delete()) System.out.println("file not deleted");
        }
    }

    @Test
    public void testWrongArgumentException(){
        mapLoad = new HashMap<>();
        mapLoad.put("file", "Customers.dat");

        try{
            LoadCustomers lc = new LoadCustomers(db);
            lc.execute(mapLoad);
        }
        catch (WrongArgumentException e){
            Assert.assertEquals("Wrong Argument", e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(!file.delete()) System.out.println("file not deleted");
        }
    }
}
