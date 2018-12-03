package View;

import Model.Customer;

public class PrintCustomer {

    public void print(Customer customer){
        System.out.println("\tid = " + customer.getId());
        System.out.println("\tname = " + customer.getName());
        System.out.println("\tphone = " + customer.getPhone());
        System.out.println("\taddress = " + customer.getAddress());
    }
}
