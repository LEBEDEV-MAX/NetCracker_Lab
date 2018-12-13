package View.CustomersView;

import Model.Customer;
import Model.CustomerDB;

import java.util.ArrayList;

public class PrintAllCustomers {

    /**
     * This method prints info about all customers
     * @param db is DB of customers
     */
    public void print(CustomerDB db){
        ArrayList<Customer> customers = db.getCustomers();

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
            System.out.println("DB is empty");
        }
    }
}
