package Controller.Actions.CustomerActions;

import Controller.Actions.Command;
import Controller.Exceptions.WrongArgumentException;
import Controller.Exceptions.WrongParameterException;
import Model.Customer;
import Model.CustomerDB;
import View.CustomersView.PrintFoundCustomer;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class find customer by his name and operation
 * operation - search principle; contains arguments: equals | contains | startWith; like
 * equals - will find customer by full name match
 * contains - will find customer if his name contains 'name' argument
 * startWith - will find customer if his name start with 'name' argument
 * like - will find customer if it matches the pattern (pattern = 'name' argument)
 */
public class FindCustomer implements Command {
    /**
     * @see Model.CustomerDB
     */
    private CustomerDB db;
    /**
     * @see View.CustomersView.PrintFoundCustomer
     */
    private PrintFoundCustomer pfc;

    public FindCustomer(CustomerDB db, PrintFoundCustomer pfc){
        this.db = db;
        this.pfc = pfc;
    }

    /**
     * @see Controller.Actions.Command
     * @param map contains (parameter -> argument)
     * @throws WrongArgumentException when user wrote wrong id argument
     * @see Controller.Exceptions.WrongArgumentException
     * @throws WrongParameterException when user wrote wrong id parameter
     * @see Controller.Exceptions.WrongParameterException
     */
    @Override
    public void execute(Map<String, String> map) throws WrongParameterException, WrongArgumentException{
        try{
            String name = getName(map);
            String operation = getOperation(map);
            ArrayList<Customer> customers = new ArrayList<>();

            switch (operation){
                case "equals":
                    db.findByEquals(name, customers);
                    break;
                case "contains":
                    db.findByContains(name, customers);
                    break;
                case "startWith":
                    db.findByStartWith(name, customers);
                    break;
                case "like":
                    db.findByLike(name, customers);
                    break;
                 default:
                     throw new WrongArgumentException("operation = " + operation + " in FindCustomer command");
            }

            pfc.print(customers, name);
        }
        catch (Exception e){
            throw e;
        }
    }

    /**
     * This method returns operation argument
     * @param map contains (parameter -> argument)
     * @return operation argument
     * @throws WrongParameterException when user wrote wrong operation parameter
     * @see Controller.Exceptions.WrongParameterException
     */
    private String getOperation(Map<String, String> map) throws WrongParameterException{
        String operation = map.get("operation");
        if(operation != null){
            return operation;
        }
        else throw new WrongParameterException("parameter 'operation' not found in FindCustomer command");
    }

    /**
     * This method returns name of customer who you want to find
     * @param map contains (parameter -> argument)
     * @return name of customer
     * @throws WrongParameterException when user wrote wrong operation parameter
     * @see Controller.Exceptions.WrongParameterException
     */
    private String getName(Map<String, String> map) throws WrongParameterException{
        String name = map.get("name");
        if(name != null){
            return name;
        }
        else throw new WrongParameterException("parameter 'name' not found in FindCustomer command");
    }
}
