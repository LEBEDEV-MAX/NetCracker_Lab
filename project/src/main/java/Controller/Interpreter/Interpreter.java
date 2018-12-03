package Controller.Interpreter;

import java.util.Map;

public interface Interpreter{
    public String getCommandName(String data);

    public Map<String, String> interpretArguments(String data);
}
