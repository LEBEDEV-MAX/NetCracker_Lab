package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Controller.Exceptions.OrderNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.OrderDB;

import java.util.Map;

public class DeleteOrder /*implements Command*/{
   /* private OrderDB db;

    public DeleteOrder(OrderDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException,
            OrderNotFoundException{
        try{
            int id = getOrderID(map);
            db.deleteOrder(id);
        }
        catch (Exception e){
            throw e;
        }
    }

    private int getOrderID(Map<String, String> map) throws WrongArgumentException, WrongParameterException {
        if(map.get("orderID") != null){
            try{
                return Integer.parseInt(map.get("orderID"));
            }
            catch (Exception e){
                throw new WrongArgumentException();
            }
        }
        else{
            throw new WrongParameterException();
        }
    }*/
}
