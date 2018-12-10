package Controller.CommandResolver;

import Controller.CommandFactory.CommandFactory;
import Controller.Exceptions.WrongCommandException;

import java.util.Map;

public class CommandResolver implements CommandFactoryResolver {
    private Map<String, CommandFactory> map;

    public CommandResolver(Map<String, CommandFactory> map){
        this.map = map;
    }

    @Override
    public CommandFactory resolveCommandFactory(String commandName) throws WrongCommandException{
        if (map.get(commandName) != null)
            return map.get(commandName);
        else
            throw new WrongCommandException();
    }
}
