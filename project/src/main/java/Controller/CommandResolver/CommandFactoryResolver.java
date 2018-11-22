package Controller.CommandResolver;

import Controller.CommandFactory.CommandFactory;

public interface CommandFactoryResolver {

    public CommandFactory resolveCommandFactory(String commandName);
}
