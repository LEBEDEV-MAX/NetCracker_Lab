package Model;

import java.util.ArrayList;

public class OrderDB {
    private ArrayList<Order> orders;

    public OrderDB(){
        orders = new ArrayList<Order>();
    }

    public void setOrders(ArrayList<Order> orders){
        this.orders = orders;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Order getOrder(int id){
        for (Order order : orders){
            if(order.getOrderID() == id) return order;
        }
        // сообщение о ненайденом клиенте
        return null;
    }

    public void deleteOrder(int id){
        for(int i=0; i < orders.size(); i++){
            if(orders.get(i).getOrderID() == id) {
                orders.remove(i);
                return;
            }
        }
        //сообщение о ненайденом клиенте
    }

    public void deleteAllOrders(){
        orders = null;
    }
}
