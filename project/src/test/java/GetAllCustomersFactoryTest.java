import Controller.Command;
import Controller.CommandFactory.GetAllCustomersFactory;
import Controller.CustomerActions.GetAllCustomers;
import Model.CustomerDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GetAllCustomersFactoryTest {
    private CustomerDB db;
    private GetAllCustomersFactory cr;

    @Before
    public void beforeTest(){
        db = new CustomerDB();
        cr = new GetAllCustomersFactory(db);
    }

    @Test
    public void test(){
        Command cmd = cr.createCommand();
        Assert.assertEquals(db, cr.getDb());
        Assert.assertTrue(cmd instanceof GetAllCustomers);
    }
}
