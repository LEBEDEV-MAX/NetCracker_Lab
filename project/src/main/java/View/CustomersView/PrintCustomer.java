package View.CustomersView;

import Model.Customer;

public class PrintCustomer {

    /**
     * This method prints information about the client you want to see by his id
     * @param customer
     */
    public void print(Customer customer){
        System.out.println("\tid = " + customer.getId());
        System.out.println("\tname = " + customer.getName());
        System.out.println("\tphone = " + customer.getPhone());
        System.out.println("\taddress = " + customer.getAddress());
    }
}
