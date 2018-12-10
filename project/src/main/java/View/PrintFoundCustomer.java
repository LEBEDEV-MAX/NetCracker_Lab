package View;

import Model.Customer;

import java.util.ArrayList;

public class PrintFoundCustomer {

    public void print(ArrayList<Customer> customers){
        if(customers.size() != 0){
            for(int i=0; i < customers.size(); i++){
                System.out.println((i+1) + ")");
                System.out.println("\tid = " + customers.get(i).getId());
                System.out.println("\tname = " + customers.get(i).getName());
                System.out.println("\tphone = " + customers.get(i).getPhone());
                System.out.println("\taddress = " + customers.get(i).getAddress());
            }
        }
        else{
            System.out.println("Customers are not found by name");
        }
    }
}
