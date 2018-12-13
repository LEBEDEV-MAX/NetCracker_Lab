package Controller.CommandResolver;

import Controller.CommandFactory.CommandFactory;
import Controller.Exceptions.WrongCommandException;

import java.util.Map;

public class CommandResolver implements CommandFactoryResolver {
    /**
     * map contains all factories of commands
     */
    private Map<String, CommandFactory> map;

    public CommandResolver(Map<String, CommandFactory> map){
        this.map = map;
    }

    /**
     * @see Controller.CommandResolver.CommandFactoryResolver
     * @param commandName ;
     * @return CommandFactory
     * @throws WrongCommandException ;
     * @see Controller.Exceptions.WrongCommandException
     */
    @Override
    public CommandFactory resolveCommandFactory(String commandName) throws WrongCommandException{
        if (map.get(commandName) != null)
            return map.get(commandName);
        else
            throw new WrongCommandException();
    }
}
