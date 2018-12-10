package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;
import View.PrintFoundCustomer;

import java.util.ArrayList;
import java.util.Map;

public class FindCustomer implements Command {
    private CustomerDB db;
    private PrintFoundCustomer pfc;

    public FindCustomer(CustomerDB db, PrintFoundCustomer pfc){
        this.db = db;
        this.pfc = pfc;
    }

    @Override
    public void execute(Map<String, String> map) throws WrongParameterException, WrongArgumentException{
        try{
            String name = getName(map);
            String operation = getOperation(map);
            ArrayList<Customer> customers = new ArrayList<>();

            switch (operation){
                case "equals":
                    findByEquals(name, customers);
                    break;
                case "contains":
                    findByContains(name, customers);
                    break;
                case "startWith":
                    findByStartWith(name, customers);
                    break;
                case "like":
                    findByLike(name, customers);
                    break;
                 default:
                     throw new WrongArgumentException();
            }

            pfc.print(customers);
        }
        catch (Exception e){
            throw e;
        }
    }

    private void findByEquals(String name, ArrayList<Customer> customers){
        ArrayList<Customer> cust = db.getCustomers();
        for (Customer c : cust){
            if(c.getName().equals(name))
                customers.add(c);
        }
    }

    private void findByContains(String name, ArrayList<Customer> customers){
        ArrayList<Customer> cust = db.getCustomers();
        for(Customer c: cust){
            if(c.getName().contains(name))
                customers.add(c);
        }
    }

    private void findByStartWith(String name, ArrayList<Customer> customers){
        ArrayList<Customer> cust = db.getCustomers();
        for(Customer c: cust){
            if(c.getName().startsWith(name))
                customers.add(c);
        }
    }

    private void findByLike(String name, ArrayList<Customer> customers){
        ArrayList<Customer> cust = db.getCustomers();
        //создаем регулярку, заменим все ? на . (ед.символ), и все * на .* (много символов)
        name = name.replaceAll("\\?", ".");
        name = name.replaceAll("\\*",".*");

        for(Customer c: cust){
            if(c.getName().matches(name))
                customers.add(c);
        }
    }

    private String getOperation(Map<String, String> map) throws WrongParameterException{
        if(map.get("operation") != null){
            return map.get("operation");
        }
        else throw new WrongParameterException();
    }

    private String getName(Map<String, String> map) throws WrongParameterException{
        if(map.get("name") != null){
            return map.get("name");
        }
        else throw new WrongParameterException();
    }

    public CustomerDB getDb() {
        return db;
    }
}
