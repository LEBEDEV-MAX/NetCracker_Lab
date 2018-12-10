package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class SaveCustomers implements Command{
    private CustomerDB db;

    public SaveCustomers(CustomerDB db){
        this.db = db;
    }

    @Override
    public void execute(Map<String, String> map) throws IOException, WrongParameterException{
        ArrayList<Customer> customers = db.getCustomers();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFileName(map), false))){
            oos.writeInt(customers.size());
            for(Customer customer : customers)
                oos.writeObject(customer);
        }
        catch (Exception e){
            throw e;
        }
    }

    private String getFileName(Map<String, String> map) throws WrongParameterException{
        if(map.get("file") != null){
            return  map.get("file");
        }
        else
            throw new WrongParameterException();
    }
}
