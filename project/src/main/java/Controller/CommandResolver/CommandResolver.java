package Controller.CommandResolver;

import Controller.CommandFactory.CommandFactory;
import java.util.Map;

public class CommandResolver implements CommandFactoryResolver {
    private Map<String, CommandFactory> map;

    public CommandResolver(Map<String, CommandFactory> map){
        this.map = map;
    }

    @Override
    public CommandFactory resolveCommandFactory(String commandName){
        return map.get(commandName);
    }
}
