package Controller;

import Controller.Actions.Command;
import Controller.CommandFactory.CommandFactory;
import Controller.CommandResolver.CommandFactoryResolver;
import Controller.Interpreter.Interpreter;
import View.PrintComplete;
import View.PrintException;

/**
 * This class sends command to its execution
 */
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

    /**
     * This method interprets command name from data,
     * create CommandFactory by command name from resolver,
     * create Command by CommandFactory,
     * interprets parametres with their arguments from data and sends their to execute() method of command.
     * Finally if there are no errors, prints message about successful execution
     * @param data string of command name with his arguments
     */
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
