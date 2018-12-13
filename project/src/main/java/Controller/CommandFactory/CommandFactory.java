package Controller.CommandFactory;

import Controller.Actions.Command;

/**
 * Basic interface for factories
 */
public interface CommandFactory {
    /**
     * This method create new command
     * @return Command
     */
    public Command createCommand();
}
