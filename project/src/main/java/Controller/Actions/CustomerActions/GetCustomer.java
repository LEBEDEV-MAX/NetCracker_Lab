package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.CustomerNotFoundException;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;
import View.PrintCustomer;

import java.util.Map;

public class GetCustomer implements Command {
    private CustomerDB db;
    private PrintCustomer pc;

    public GetCustomer(CustomerDB db, PrintCustomer pc){
        this.db = db;
        this.pc = pc;
    }

    @Override
    public void execute(Map<String, String> map) throws WrongArgumentException, WrongParameterException,
            CustomerNotFoundException{
        try{
            int id = getID(map);
            Customer customer = getCustomerByID(id);

            pc.print(customer);
        }
        catch (Exception e){
            throw e;
        }
    }

    private Customer getCustomerByID(int id) throws CustomerNotFoundException{
        if (db.getCustomer(id) != null) {
            return db.getCustomer(id);
        }
        else{
            throw new CustomerNotFoundException();
        }
    }

    private int getID(Map<String, String> map) throws WrongArgumentException, WrongParameterException {
        if(map.get("id") != null){
            try{
                return Integer.parseInt(map.get("id"));
            }
            catch (Exception e){
                throw new WrongArgumentException();
            }
        }
        else{
            throw new WrongParameterException();
        }
    }

    public CustomerDB getDB(){
        return db;
    }
}
