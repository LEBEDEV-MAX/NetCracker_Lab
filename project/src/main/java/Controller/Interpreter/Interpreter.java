package Controller.Interpreter;

import java.util.Map;

/**
 * Basic interface for interpreters
 */
public interface Interpreter{
    /**
     * This method needs to interpret command name
     * @param data string of command name with his arguments
     * @return command name
     */
    public String getCommandName(String data);

    /**
     * This method needs to interpret arguments of command
     * @param data string of command name with his arguments
     * @return arguments: (parameter name -> argument)
     */
    public Map<String, String> interpretArguments(String data);
}
