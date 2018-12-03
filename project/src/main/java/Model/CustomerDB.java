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

    public Customer getCustomer(int id){
        for (Customer customer : customers){
            if(customer.getId() == id) return customer;
        }
        // сообщение о ненайденом клиенте
        return null;
    }

    public void deleteCustomer(int id){
        for(int i=0; i < customers.size(); i++){
            if(customers.get(i).getId() == id) {
                customers.remove(i);
                return;
            }
        }
        //сообщение о ненайденом клиенте
    }

    public void deleteAllCustomers(){
        for(Customer customer: customers){
            customer = null;
        }
    }
}
