import Controller.CommandFactory.CommandFactory;
import Controller.CommandFactory.CustomerFactories.*;
import Controller.CommandFactory.OrderFactories.*;
import Controller.CommandResolver.CommandResolver;
import Controller.OrderActions.GetAllOrders;
import Controller.OrderActions.GetOrder;
import Controller.OrderActions.UpdateOrder;
import Model.CustomerDB;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CommandResolverTest {
    private CommandResolver cr;

    @Before
    public void beforeTest(){
        Map<String, CommandFactory> map = new HashMap<>();
        CustomerDB customerDB = new CustomerDB();
        OrderDB orderDB = new OrderDB();

        map.put("CreateCustomer", new CreateCustomerFactory(customerDB));
        map.put("DeleteAllCustomers", new DeleteAllCustomerFactory(customerDB));
        map.put("DeleteCustomer", new DeleteCustomerFactory(customerDB));
        map.put("GetAllCustomers", new GetAllCustomersFactory(customerDB));
        map.put("GetCustomer", new GetCustomerFactory(customerDB));
        map.put("UpdateCustomer", new UpdateCustomerFactory(customerDB));
        //
        map.put("CreateOrder", new CreateOrderFactory(orderDB));
        map.put("DeleteAllOrders", new DeleteAllOrdersFactory(orderDB));
        map.put("DeleteOrder", new DeleteOrderFactory(orderDB));
        map.put("GetAllOrders", new GetAllOrdersFactory(orderDB));
        map.put("GetOrder", new GetOrderFactory(orderDB));
        map.put("UpdateOrder", new UpdateOrderFactory(orderDB));

        cr = new CommandResolver(map);
    }

    @Test
    public void testCreateCustomer(){
        String str = "CreateCustomer";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof CreateCustomerFactory);
    }

    @Test
    public void testDeleteAllCustomers(){
        String str = "DeleteAllCustomers";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof DeleteAllCustomerFactory);
    }

    @Test
    public void testDeleteCustomer(){
        String str = "DeleteCustomer";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof DeleteCustomerFactory);
    }

    @Test
    public void testGetAllCustomers(){
        String str = "GetAllCustomers";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetAllCustomersFactory);
    }

    @Test
    public void testGetCustomer(){
        String str = "GetCustomer";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetCustomerFactory);
    }

    @Test
    public void testUpdateCustomer(){
        String str = "UpdateCustomer";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof UpdateCustomerFactory);
    }

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
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetAllOrders);
    }

    @Test
    public void testGetOrder(){
        String str = "GetOrder";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetOrder);
    }

    @Test
    public void testUpdateOrder(){
        String str = "UpdateOrder";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof UpdateOrder);
    }
}
