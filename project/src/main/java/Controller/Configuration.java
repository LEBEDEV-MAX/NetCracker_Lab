package Controller;

import Controller.CommandFactory.CommandFactory;
import Controller.CommandFactory.CustomerFactories.*;
import Controller.CommandResolver.*;
import Controller.Interpreter.*;
import Model.CustomerDB;
import Model.OrderDB;
import View.*;
import View.CustomersView.PrintAllCustomers;
import View.CustomersView.PrintCustomer;
import View.CustomersView.PrintFoundCustomer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * This class create other classes of the program
 */
public class Configuration {

    /**
     * Create Resolver and Interpreter and sends them to TerminalController
     * @return TerminalController
     * @see Controller.TerminalController
     */
    public TerminalController createTerminalController(){
        return new TerminalController(createResolver(), createInterpreter(),
                createPE(), createComplete());
    }

    /**
     * Create new Interpreter
     * @see Controller.Interpreter
     * @return Interpeter
     */
    @NotNull
    private Interpreter createInterpreter(){
        return new InterpreterImpl();
    }

    /**
     * Create new Resolver
     * @see Controller.CommandResolver.CommandFactoryResolver
     * @return CommandFactoryResolver
     */
    @NotNull
    private CommandFactoryResolver createResolver(){
        Map<String, CommandFactory> map = new HashMap<>();
        CustomerDB customerDB = createCustomerDB();
       // OrderDB orderDB = createOrderDB();

        map.put("CreateCustomer", new CreateCustomerFactory(customerDB));
        map.put("DeleteAllCustomers", new DeleteAllCustomerFactory(customerDB));
        map.put("DeleteCustomer", new DeleteCustomerFactory(customerDB));
        map.put("GetAllCustomers", new GetAllCustomersFactory(customerDB, createPAC()));
        map.put("GetCustomer", new GetCustomerFactory(customerDB, createPC()));
        map.put("UpdateCustomer", new UpdateCustomerFactory(customerDB));
        map.put("SaveCustomers", new SaveCustomersFactory(customerDB, createService()));
        map.put("LoadCustomers", new LoadCustomersFactory(customerDB, createService()));
        map.put("FindCustomer", new FindCustomerFactory(customerDB, createPFC()));
        //
        /*
        map.put("CreateOrder", new CreateOrderFactory(orderDB));
        map.put("DeleteAllOrders", new DeleteAllOrdersFactory(orderDB));
        map.put("DeleteOrder", new DeleteOrderFactory(orderDB));
        map.put("GetAllOrders", new GetAllOrdersFactory(orderDB));
        map.put("GetOrder", new GetOrderFactory(orderDB));
        map.put("UpdateOrder", new UpdateOrderFactory(orderDB));
*/
        return new CommandResolver(map);
    }

    /**
     * Create CustomerDB
     * @return CustomerDB
     * @see Model.CustomerDB
     */
    @NotNull
    private CustomerDB createCustomerDB(){
        return new CustomerDB();
    }

    /*@NotNull
    private OrderDB createOrderDB(){
        return new OrderDB();
    }*/

    /**
     * Create new PrintException
     * @see View.PrintException
     * @return PrintException
     */
    @NotNull
    private PrintException createPE(){
        return new PrintException();
    }

    /**
     * Create new PrintAllCustomers
     * @see View.CustomersView.PrintAllCustomers
     * @return PrintAllCustomers
     */
    @NotNull
    private PrintAllCustomers createPAC(){
        return new PrintAllCustomers();
    }

    /**
     * Create new PrintCustomer
     * @see View.CustomersView.PrintCustomer
     * @return PrintAllCustomers
     */
    @NotNull
    private PrintCustomer createPC(){
        return new PrintCustomer();
    }

    /**
     * Create new PrintComplete
     * @see View.PrintComplete
     * @return PrintComplete
     */
    @NotNull
    private PrintComplete createComplete(){
        return new PrintComplete();
    }

    /**
     * Create new PrintMainMenu
     * @see View.PrintMainMenu
     * @return PrintMainMenu
     */
    @NotNull
    public PrintMainMenu createMainMenu(){
        return new PrintMainMenu();
    }

    /**
     * Create new PrintFoundCustomer
     * @see View.CustomersView.PrintFoundCustomer
     * @return PrintMainMenu
     */
    @NotNull
    public PrintFoundCustomer createPFC(){
        return new PrintFoundCustomer();
    }

    /**
     * Create new StreamService
     * @see Controller.StreamService
     * @return StreamService
     */
    @NotNull
    public StreamService createService(){
        return new StreamService();
    }
}
