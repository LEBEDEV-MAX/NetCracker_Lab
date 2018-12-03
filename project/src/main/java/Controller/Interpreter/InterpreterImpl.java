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
        String[] arguments = data.split(";");
        for (String arg : arguments){
            String[] a = arg.split("=");
            try {
                map.put(a[0].trim(), a[1].trim());
            }
            catch (ArrayIndexOutOfBoundsException e){
                printException(e);
            }
        }
        return  map;
    }

    private String replace(String data){
        String commandName = getCommandName(data);
        return data.replaceAll(commandName, "");
    }

    private void printException(Exception e){
        //ArrayIndexOutOfBoundsException
    }
}
