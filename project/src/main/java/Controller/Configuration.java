package Controller;

import Controller.CommandFactory.CommandFactory;
import Controller.CommandFactory.CustomerFactories.*;
import Controller.CommandFactory.OrderFactories.*;
import Controller.CommandResolver.*;
import Controller.Interpreter.*;
import Model.CustomerDB;
import Model.OrderDB;
import View.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public TerminalController createTerminalController(){
        return new TerminalController(createResolver(), createInterpreter(),
                createPE(), createComplete());
    }

    @NotNull
    private Interpreter createInterpreter(){
        return new InterpreterImpl();
    }

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
        map.put("SaveCustomers", new SaveCustomersFactory(customerDB));
        map.put("LoadCustomers", new LoadCustomersFactory(customerDB));
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

    @NotNull
    private CustomerDB createCustomerDB(){
        return new CustomerDB();
    }

    @NotNull
    private OrderDB createOrderDB(){
        return new OrderDB();
    }

    @NotNull
    private PrintException createPE(){
        return new PrintException();
    }

    @NotNull
    private PrintAllCustomers createPAC(){
        return new PrintAllCustomers();
    }

    @NotNull
    private PrintCustomer createPC(){
        return new PrintCustomer();
    }

    @NotNull
    private PrintComplete createComplete(){
        return new PrintComplete();
    }

    @NotNull
    public PrintMainMenu createMainMenu(){
        return new PrintMainMenu();
    }

    @NotNull
    public PrintFoundCustomer createPFC(){
        return new PrintFoundCustomer();
    }
}
