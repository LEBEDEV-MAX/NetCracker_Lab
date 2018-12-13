package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Order;
import Model.OrderDB;

import java.util.Map;

public class CreateOrder /*implements Command*/ {
   /* private OrderDB orderDB;

    public CreateOrder(OrderDB orderDB){
        this.orderDB = orderDB;
    }

    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException{
        try{
            Order order = new Order(
                    getIntArgument(map, "customerID"),
                    getIntArgument(map, "orderID"),
                    getStringArgument(map, "date"),
                    getIntArgument(map,"sum")
            );
            orderDB.addOrder(order);
        }
        catch (Exception e){
            throw e;
        }
    }

    private int getIntArgument(Map<String, String> map, String name) throws WrongArgumentException, WrongParameterException {
        if(map.get(name) != null){
            try{
                return Integer.parseInt(map.get(name));
            }
            catch (Exception e){
                throw new WrongArgumentException();
            }
        }
        else{
            throw new WrongParameterException();
        }
    }

    private String getStringArgument(Map<String, String> map, String argumentName) throws WrongParameterException {
        if(map.get(argumentName) != null)
            return map.get(argumentName);
        else
            throw new WrongParameterException();
    }
*/
}
