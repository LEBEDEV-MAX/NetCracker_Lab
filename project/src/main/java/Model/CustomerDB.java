package Model;

import Controller.Exceptions.CustomerNotFoundException;

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

    public Customer getCustomer(int id){
        for (Customer customer : customers){
            if(customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void deleteCustomer(int id) throws CustomerNotFoundException{
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId() == id) {
                customers.remove(i);
                return;
            }
        }
        //if customer not found:
        throw new CustomerNotFoundException();
    }

    public void deleteAllCustomers(){
       customers.clear();
    }
}
