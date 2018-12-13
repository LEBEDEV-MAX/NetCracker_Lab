package View.OrdersView;

import Model.Order;
import Model.OrderDB;

import java.util.ArrayList;

public class PrintAllOrders {

    public void print(OrderDB db){
        ArrayList<Order> orders = db.getOrders();

        if(orders.size() != 0){
            for(int i=0; i< orders.size(); i++){
                System.out.println((i+1) + ")");
                System.out.println("\tcustomerID = " + orders.get(i).getCustomerID());
                System.out.println("\torderID = " + orders.get(i).getOrderID());
                System.out.println("\tdate = " + orders.get(i).getDate());
                System.out.println("\tsum = " + orders.get(i).getSum());
            }
        }
        else{
            System.out.println("DB is empty");
        }
    }
}
