package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Controller.StreamService;
import Model.Customer;
import Model.CustomerDB;

import java.io.*;
import java.util.Map;

/**
 * This class loads all customers from file in DB by dublicatePolicy argument
 * dublicatePolicy - load principle; contains arguments: skip | replace
 * replace - (default argument) if customer's id in DB = customer's id in the file,
 *                                  then new customer replace old customer
 *                              else new customer added to DB
 * skip - if customer's id in DB = customer's id in the file, then new customer no added to DB
 *        else new customer added to DB
 */
public class LoadCustomers implements Command{
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;
    /**
     * @see Controller.StreamService
     */
    private StreamService service;

    public LoadCustomers(CustomerDB db, StreamService service){
        this.db = db;
        this.service = service;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     * @throws WrongArgumentException when user wrote wrong id argument
     * @see Controller.Exceptions.WrongArgumentException
     * @throws WrongParameterException when user wrote wrong id | name | phone | address parameters
     * @see Controller.Exceptions.WrongParameterException
     * @throws ClassNotFoundException when customer object was not found in the file
     */
    @Override
    public void execute(Map<String, String> map) throws IOException, WrongParameterException, WrongArgumentException,
            ClassNotFoundException {
        ////////////////
        String dp = getDublicatePolicy(map);

        try(ObjectInputStream ois = service.getOIS(getFileName(map))){
            int size = ois.readInt();

            for(int i=0; i < size; i++){
                Customer customer =(Customer) ois.readObject();

                if(dp == null || dp.equals("replace"))
                    loadWithReplace(customer);
                else if(dp.equals("skip"))
                    loadWithSkip(customer);
                else
                    throw new WrongArgumentException("dublicatePolicy = " + dp + " in LoadCustomers command");
            }
        }
        catch (Exception e){
            throw e;
        }

    }

    /**
     * This method returns file name argument
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
            throw new WrongParameterException("parameter 'file' not found in LoadCustomers command");
    }

    /**
     * This method returns dublicate policy argument
     * @param map contains (parameter -> argument)
     * @return dublicatePolicy argumeent
     */
    private String getDublicatePolicy(Map<String, String> map){
        return map.get("dublicatePolicy");
    }

    /**
     * This method loads customers in DB with replace argument
     * @param newCustomer it's customer from file
     */
    private void loadWithReplace(Customer newCustomer){
        int id = newCustomer.getId();
        Customer customer = db.getCustomer(id);

        if(customer != null){
            int i = db.getIndexOfCustomer(customer);
            db.replaceCustomer(i, newCustomer);
        }
        else{
            db.addCustomer(newCustomer);
        }
    }

    /**
     * This method loads customers in DB with skip argument
     * @param newCustomer it's customer from file
     */
    private void loadWithSkip(Customer newCustomer){
        int id = newCustomer.getId();
        Customer customer = db.getCustomer(id);

        if(customer == null){
            db.addCustomer(newCustomer);
        }
    }
}
