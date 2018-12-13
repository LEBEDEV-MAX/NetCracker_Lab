package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongParameterException;
import Controller.StreamService;
import Model.Customer;
import Model.CustomerDB;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class saves all customers to the file
 */
public class SaveCustomers implements Command{
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;
    /**
     * @see Controller.StreamService
     */
    private StreamService service;

    public SaveCustomers(CustomerDB db, StreamService service){
        this.db = db;
        this.service = service;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     * @throws IOException when error occurred while saving the file
     * @throws WrongParameterException when user wrote wrong id | name | phone | address parameters
     * @see Controller.Exceptions.WrongParameterException
     */
    @Override
    public void execute(Map<String, String> map) throws IOException, WrongParameterException{
        ArrayList<Customer> customers = db.getCustomers();

        try(ObjectOutputStream oos = service.getOOS(getFileName(map))){
            oos.writeInt(customers.size());
            for(Customer customer : customers)
                oos.writeObject(customer);
        }
        catch (Exception e){
            throw e;
        }
    }

    /**
     * This method returns file name
     * @param map contains (parameter -> argument)
     * @return file name
     * @throws WrongParameterException when user wrote wrong id | name | phone | address parameters
     * @see Controller.Exceptions.WrongParameterException
     */
    private String getFileName(Map<String, String> map) throws WrongParameterException{
        String file = map.get("file");
        if(file != null){
            return  file;
        }
        else
            throw new WrongParameterException("parameter 'file' not found in SaveCustomers command");
    }
}
