package Controller.CommandResolver;

import Controller.CommandFactory.CommandFactory;
import Controller.Exceptions.WrongCommandException;

/**
 * Basic interface for resolver
 */
public interface CommandFactoryResolver {
    /**
     * This method returns specific factory by command name from data
     * @param commandName ;
     * @return CommandFactory
     * @see Controller.CommandFactory.CommandFactory
     * @throws WrongCommandException ;
     * @see Controller.Exceptions.WrongCommandException
     */
    public CommandFactory resolveCommandFactory(String commandName) throws WrongCommandException;
}
