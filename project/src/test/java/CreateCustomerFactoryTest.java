import Controller.Command;
import Controller.CommandFactory.CreateCustomerFactory;
import Controller.CustomerActions.CreateCustomer;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CreateCustomerFactoryTest {
    private CustomerDB db;
    private CreateCustomerFactory cr;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        cr = new CreateCustomerFactory(db);
    }

    @Test
    public void test(){
        Command cmd = cr.createCommand();
        Assert.assertEquals(db, cr.getDb());
        Assert.assertTrue(cmd instanceof CreateCustomer);
    }
}
