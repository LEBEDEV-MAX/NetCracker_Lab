package Controller;

public class Configuration {

    public TerminalController createTerminalController(String data){
        return new TerminalController(data);
    }

    public Interpreter createInterpreter(String data){
        return new Interpreter(data);
    }

    /*public CommandResolver createCommandResolver(){
        return new CommandResolver(customerDB, O);
    }*/
}
