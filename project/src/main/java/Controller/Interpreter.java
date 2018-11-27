package Controller;

import java.util.HashMap;
import java.util.Map;

public class Interpreter {
    private String data;
    private  Map<String, String> map;
    private String[] pNames = new String[]
            {"id=", "name=", "phone=", "address=", "customerID=", "orderID=", "date=", "sum="};

    public Interpreter(String data){
        this.data = data;
        map = new HashMap<String,String>();
    }

    public String getCommandName(){
        String commandName;
        commandName = data.split(" ")[0];
        return commandName;
    }

    public Map<String, String> interpretArguments(){
        map.clear();
        String[] arguments = data.split(";");

        for (String p : arguments){
            for(String pName : pNames){
                if(p.contains(pName)){
                    int paramIndex = p.indexOf(pName) + pName.length(); //индекс начала параметра
                    String param = p.substring(paramIndex, p.length());
                    //param = param.replaceAll("\\s","");
                    map.put(pName, param);
                }
            }
        }
        return  map;
    }
}
