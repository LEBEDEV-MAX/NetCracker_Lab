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

    public Order getOrder(int index){
        return orders.get(index);
    }

    public void deleteOrder(int index){
        orders.remove(index);
    }
}
