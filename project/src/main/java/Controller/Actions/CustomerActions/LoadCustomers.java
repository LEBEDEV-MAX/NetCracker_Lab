package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class LoadCustomers implements Command{
    private CustomerDB db;

    public LoadCustomers(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map) throws IOException, WrongParameterException, WrongArgumentException,
            ClassNotFoundException {
        ////////////////
        ArrayList<Customer> newCust = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFileName(map)))){
            int size = ois.readInt();
            for(int i=0; i < size; i++){
                Customer customer =(Customer) ois.readObject();
                newCust.add(customer);
            }
        }
        catch (Exception e){
            throw e;
        }

        db.deleteAllCustomers();  // очистить БД перед загрузкой нового  // ЕСЛИ НЕ СРАВНИВАТЬ С ТЕМ ЧТО УЖЕ ЕСТЬ
        String dp = getDublicatePolicy(map);

        if(dp == null || dp.equals("replace"))
            loadWithReplace(newCust);
        else if(dp.equals("skip"))
            loadWithSkip(newCust);
        else
            throw new WrongArgumentException();
    }

    private String getFileName(Map<String, String> map) throws WrongParameterException{
        if(map.get("file") != null){
            return  map.get("file");
        }
        else
            throw new WrongParameterException();
    }

    private String getDublicatePolicy(Map<String, String> map){
        return map.get("dublicatePolicy");
    }

    private void loadWithSkip( ArrayList<Customer> newCust){
        boolean b = true;

        for(Customer customer1 : newCust){
            for(Customer customer : db.getCustomers()){
                if(customer1.getId() == customer.getId()){
                    b = false;
                    break;
                }
            }

            if(b) db.addCustomer(customer1);
            b = true;
        }
    }

    private void loadWithReplace(ArrayList<Customer> newCust){
        boolean b = true;
        ArrayList<Customer> customers = db.getCustomers();

        for(Customer cust : newCust){
            for(int i=0; i < customers.size(); i++){
                if(customers.get(i).getId() == cust.getId()){
                    customers.set(i, cust);
                    b = false;
                    break;
                }
            }

            if(b) customers.add(cust);
            b = true;
        }
    }
}
