import Controller.Interpreter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InterpreterTest {
    private String data;
    private String commandName;
    private Map<String, String> map;
    private Interpreter interpreter;

    @Before
    public void beforeTest(){
        data = "CreateCustomer id=1; name=Ivan; phone=+12345678901; address=Russia";
        commandName = "CreateCustomer";
        map = new HashMap<>();
        map.put("id=", "1");
        map.put("name=", "Ivan");
        map.put("phone=", "+12345678901");
        map.put("address=", "Russia");
    }

    @Test
    public void testGetCommandName(){
        interpreter = new Interpreter(data);
        Assert.assertEquals(commandName, interpreter.getCommandName());
    }

    @Test
    public void testInterpretArguments(){
        interpreter = new Interpreter(data);
        Assert.assertEquals(map, interpreter.interpretArguments());
    }
}
