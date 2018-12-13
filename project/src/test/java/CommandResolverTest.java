import Controller.CommandFactory.CommandFactory;
import Controller.CommandFactory.CustomerFactories.*;
import Controller.CommandResolver.CommandResolver;
import Controller.Exceptions.WrongCommandException;
import Controller.StreamService;
import Model.CustomerDB;
import View.CustomersView.PrintAllCustomers;
import View.CustomersView.PrintCustomer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CommandResolverTest {
    private PrintCustomer pc;
    private PrintAllCustomers pac;
    private Map<String, CommandFactory> map;
    private StreamService service;

    @Before
    public void beforeTest(){
        map = new HashMap<>();
        CustomerDB customerDB = new CustomerDB();
       ////// OrderDB orderDB = new OrderDB();
        pc = new PrintCustomer();
        pac = new PrintAllCustomers();
        service = new StreamService();

        map.put("CreateCustomer", new CreateCustomerFactory(customerDB));
        map.put("DeleteAllCustomers", new DeleteAllCustomerFactory(customerDB));
        map.put("DeleteCustomer", new DeleteCustomerFactory(customerDB));
        map.put("GetAllCustomers", new GetAllCustomersFactory(customerDB, pac));
        map.put("GetCustomer", new GetCustomerFactory(customerDB, pc));
        map.put("UpdateCustomer", new UpdateCustomerFactory(customerDB));
        map.put("SaveCustomers", new SaveCustomersFactory(customerDB, service));
        map.put("LoadCustomers", new LoadCustomersFactory(customerDB, service));
        //
      /*  map.put("CreateOrder", new CreateOrderFactory(orderDB));
        map.put("DeleteAllOrders", new DeleteAllOrdersFactory(orderDB));
        map.put("DeleteOrder", new DeleteOrderFactory(orderDB));
        map.put("GetAllOrders", new GetAllOrdersFactory(orderDB));
        map.put("GetOrder", new GetOrderFactory(orderDB));
        map.put("UpdateOrder", new UpdateOrderFactory(orderDB));
*/
    }

    @Test
    public void testCreateCustomer(){
        String str = "CreateCustomer";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof CreateCustomerFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteAllCustomers(){
        String str = "DeleteAllCustomers";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof DeleteAllCustomerFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testDeleteCustomer(){
        String str = "DeleteCustomer";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof DeleteCustomerFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllCustomers(){
        String str = "GetAllCustomers";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetAllCustomersFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testGetCustomer(){
        String str = "GetCustomer";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetCustomerFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateCustomer(){
        String str = "UpdateCustomer";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof UpdateCustomerFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveCustomers(){
        String str = "SaveCustomers";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof SaveCustomersFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadCustomers(){
        String str = "LoadCustomers";
        try{
            CommandResolver cr = new CommandResolver(map);

            Assert.assertTrue(cr.resolveCommandFactory(str) instanceof LoadCustomersFactory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(expected = WrongCommandException.class)
    public void testWrongCommandException() throws Exception{
        String str = "a";

        CommandResolver cr = new CommandResolver(map);
        cr.resolveCommandFactory(str);
    }

/*
    @Test
    public void testCreateOrder(){
        String str = "CreateOrder";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof CreateOrderFactory);
    }

    @Test
    public void testDeleteAllOrders(){
        String str = "DeleteAllOrders";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof DeleteAllOrdersFactory);
    }

    @Test
    public void testDeleteOrder(){
        String str = "DeleteOrder";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof DeleteOrderFactory);
    }

    @Test
    public void testGetAllOrders(){
        String str = "GetAllOrders";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetAllOrdersFactory);
    }

    @Test
    public void testGetOrder(){
        String str = "GetOrder";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetOrderFactory);
    }

    @Test
    public void testUpdateOrder(){
        String str = "UpdateOrder";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof UpdateOrderFactory);
    }
    */
}
