package Controller.Actions;

import java.util.Map;

/**
 * Basic interface for commands
 */
public interface Command {
    /**
     * This method runs command execution
     * @param map contains with (parameter -> argument)
     */
    public void execute(Map<String, String> map) throws Exception;
}
