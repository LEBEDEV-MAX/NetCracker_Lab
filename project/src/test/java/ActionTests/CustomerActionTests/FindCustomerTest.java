package ActionTests.CustomerActionTests;

import Controller.Actions.CustomerActions.FindCustomer;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;
import View.CustomersView.PrintFoundCustomer;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FindCustomerTest {
    private CustomerDB db;
    private Customer customer;
    private PrintFoundCustomer pfc;
    private Map<String, String> map;

    @Before
    public void beforeTest(){
        customer = new Customer(1, "Igor", "+09876543210", "USA");

        db = new CustomerDB();
        db.addCustomer(customer);

        pfc = new PrintFoundCustomer();
        map = new HashMap<>();
    }

    @Test
    public void testExecute(){
        map.put("name", "Igor");
        map.put("operation", "equals");

        try{
            FindCustomer fc = new FindCustomer(db,pfc);
            fc.execute(map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(expected = WrongArgumentException.class)
    public void testWrongArgumentException() throws Exception{
        map = new HashMap<>();
        map.put("name", "Igor");
        map.put("operation", "a");

        FindCustomer fc = new FindCustomer(db,pfc);
        fc.execute(map);
    }

    @Test(expected = WrongParameterException.class)
    public void testWrongParameterException() throws Exception{
        map = new HashMap<>();
        map.put("na me", "Igor");
        map.put("oper ation", "equals");

        FindCustomer fc = new FindCustomer(db,pfc);
        fc.execute(map);
    }
}
