import Controller.CommandFactory.CreateCustomerFactory;
import Controller.CommandFactory.GetAllCustomersFactory;
import Controller.CommandResolver.CommandResolver;
import Model.CustomerDB;
import Model.OrderDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandFactoryResolverTest {
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
    public void testGetAllCustomers(){
        String str = "GetAllCustomers";
        Assert.assertTrue(cr.resolveCommandFactory(str) instanceof GetAllCustomersFactory);
    }
}
