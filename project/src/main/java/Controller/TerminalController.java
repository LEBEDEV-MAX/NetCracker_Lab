package Controller;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.CommandResolver.CommandFactoryResolver;
import Controller.Interpreter.Interpreter;
import View.PrintComplete;
import View.PrintException;

public class TerminalController{
    private CommandFactoryResolver cfr;
    private Interpreter interpreter;
    private PrintException printE;
    private PrintComplete complete;

    public TerminalController(CommandFactoryResolver cfr, Interpreter interpreter,
                              PrintException printE, PrintComplete complete){
        this.cfr = cfr;
        this.interpreter = interpreter;
        this.printE = printE;
        this.complete = complete;
    }

    public void start(String data){
        String commandName = interpreter.getCommandName(data);

        try{
            CommandFactory cf= cfr.resolveCommandFactory(commandName);
            Command cmd = cf.createCommand();
            cmd.execute(interpreter.interpretArguments(data));
            complete.print();
        }
        catch (Exception e){
            printE.print(e);
        }
    }
}
