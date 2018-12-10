package Controller.Actions;

import java.util.Map;

public interface Command {
    public void execute(Map<String, String> map) throws Exception;
}
