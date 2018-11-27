import Controller.CommandFactory.CustomerFactories.*;
import Controller.CommandResolver.CommandResolver;
import Model.CustomerDB;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandResolverTest {
    private CustomerDB customerDB;
    private OrderDB orderDB;
    private CommandResolver cr;

    @Before
    public void beforeTest(){
        customerDB = new CustomerDB();
        orderDB = new OrderDB();
        cr = new CommandResolver(customerDB, orderDB);
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
}
