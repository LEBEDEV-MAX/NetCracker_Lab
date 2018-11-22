package Model;

import java.util.ArrayList;

public class CustomerDB {
    private ArrayList<Customer> customers;

    public CustomerDB(){
        customers = new ArrayList<Customer>();
    }

    public void setCustomers(ArrayList<Customer> customers){
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
            return customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }

    public void deleteCustomer(int index){
        customers.remove(index);
    }
}
