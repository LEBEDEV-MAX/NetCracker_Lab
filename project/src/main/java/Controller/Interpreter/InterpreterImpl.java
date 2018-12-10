package Controller.Interpreter;

import java.util.HashMap;
import java.util.Map;

public class InterpreterImpl implements Interpreter {

    @Override
    public String getCommandName(String data){
        return data.split(" ")[0];
    }

    @Override
    public Map<String, String> interpretArguments(String data){
        Map<String, String> map = new HashMap<String,String>();

        data = replace(data);
        if(data.contains("=")) {
            String[] arguments = data.split(";");
            for (String arg : arguments) {
                String[] a = arg.split("=");
                map.put(a[0].trim(), a[1].trim());
            }
        }
        return map;
    }

    private String replace(String data){
        String commandName = getCommandName(data);
        return data.replaceAll(commandName, "");
    }
}
