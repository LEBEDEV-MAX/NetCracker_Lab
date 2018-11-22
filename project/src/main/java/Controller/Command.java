package Controller;

import java.util.Map;

public interface Command {
    public void execute(Map<String, String> map);
}
