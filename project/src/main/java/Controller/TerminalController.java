package Controller;

import Controller.CommandFactory.CommandFactory;
import Controller.CommandResolver.CommandFactoryResolver;
import Controller.Interpreter.Interpreter;

public class TerminalController{
    private CommandFactoryResolver cfr;
    private Interpreter interpreter;

    public TerminalController(CommandFactoryResolver cfr, Interpreter interpreter){
        this.cfr = cfr;
        this.interpreter = interpreter;
    }

    public void method(String data){
        String commandName = interpreter.getCommandName(data);
        try{
            CommandFactory cf = cfr.resolveCommandFactory(commandName);
            Command cmd = cf.createCommand();
            cmd.execute(interpreter.interpretArguments(data));
        }
        catch (NullPointerException e){
            System.out.println("Неверная команда");
        }
    }
}
