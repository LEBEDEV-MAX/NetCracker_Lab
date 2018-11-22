package Controller;

import Controller.CommandFactory.*;
import Controller.CommandResolver.CommandResolver;
import Model.CustomerDB;
import Model.OrderDB;

import java.util.Map;

public class TerminalController{
    private String data;
    private Map<String, String> map;
    private CustomerDB customerDB;
    private OrderDB orderDB;

    public TerminalController(String data){
        this.data = data;
        orderDB = new OrderDB();
        customerDB = new CustomerDB();
    }

    public void method(){
        Interpreter interpreter = new Interpreter(data);
        String commandName = interpreter.getCommandName();
        CommandResolver resolver = new CommandResolver(customerDB, orderDB);
        CommandFactory cf = resolver.resolveCommandFactory(commandName);
        Command cmd = cf.createCommand();
        map = interpreter.interpretArguments();
        cmd.execute(map);
    }
}
