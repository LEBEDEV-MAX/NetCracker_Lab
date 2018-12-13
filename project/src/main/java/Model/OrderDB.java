package Model;

import Controller.Exceptions.OrderNotFoundException;

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
        for(Order order: orders){
            if(order.getOrderID() == id){
                return order;
            }
        }
        return null;
    }

    public void deleteOrder(int id) throws OrderNotFoundException{
        for(int i=0; i < orders.size(); i++){
            if(orders.get(i).getOrderID() == id) {
                orders.remove(i);
                return;
            }
        }
        //if order not found
        throw new OrderNotFoundException();
    }

    public void deleteAllOrders(){
        orders.clear();
    }
}
