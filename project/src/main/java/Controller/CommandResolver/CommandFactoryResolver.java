package Controller.CommandResolver;

import Controller.CommandFactory.CommandFactory;
import Controller.Exceptions.WrongCommandException;

public interface CommandFactoryResolver {

    public CommandFactory resolveCommandFactory(String commandName) throws WrongCommandException;
}
