import Controller.Interpreter.InterpreterImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InterpreterImplTest {
    private String data;
    private String commandName;
    private Map<String, String> map;
    private InterpreterImpl interpreterImpl;

    @Before
    public void beforeTest(){
        data = "CreateCustomer id=1; name=Ivan; phone=+12345678901; address=Russia";
        commandName = "CreateCustomer";
        map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "Ivan");
        map.put("phone", "+12345678901");
        map.put("address", "Russia");
    }

    @Test
    public void testGetCommandName(){
        interpreterImpl = new InterpreterImpl();
        Assert.assertEquals(commandName, interpreterImpl.getCommandName(data));
    }

    @Test
    public void testInterpretArguments(){
        interpreterImpl = new InterpreterImpl();
        Assert.assertEquals(map, interpreterImpl.interpretArguments(data));
    }
}
