package Controller.Actions.OrderActions;

import Controller.Actions.Command;
import Model.OrderDB;

import java.util.Map;

public class DeleteOrder implements Command{
    private OrderDB db;

    public DeleteOrder(OrderDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map){
        if (map.get("id=") != null){
            int index = Integer.parseInt(map.get("id=")); // прописать try catch
            db.deleteOrder(index);
        }
        else{
            //ошбика не найден айдишник кого удалять
        }
    }
}
