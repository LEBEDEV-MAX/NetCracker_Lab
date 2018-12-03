package Controller;

import Controller.CommandFactory.CommandFactory;
import Controller.CommandFactory.CustomerFactories.*;
import Controller.CommandFactory.OrderFactories.*;
import Controller.CommandResolver.*;
import Controller.Interpreter.*;
import Model.CustomerDB;
import Model.OrderDB;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public TerminalController createTerminalController(){
        return new TerminalController(createResolver(), createInterpreter());
    }

    private Interpreter createInterpreter(){
        return new InterpreterImpl();
    }

    private CommandFactoryResolver createResolver(){
        Map<String, CommandFactory> map = new HashMap<>();
        CustomerDB customerDB = createCustomerDB();
        OrderDB orderDB = createOrderDB();

        map.put("CreateCustomer", new CreateCustomerFactory(customerDB));
        map.put("DeleteAllCustomers", new DeleteAllCustomerFactory(customerDB));
        map.put("DeleteCustomer", new DeleteCustomerFactory(customerDB));
        map.put("GetAllCustomers", new GetAllCustomersFactory(customerDB));
        map.put("GetCustomer", new GetCustomerFactory(customerDB));
        map.put("UpdateCustomer", new UpdateCustomerFactory(customerDB));
        //
        map.put("CreateOrder", new CreateOrderFactory(orderDB));
        map.put("DeleteAllOrders", new DeleteAllOrdersFactory(orderDB));
        map.put("DeleteOrder", new DeleteOrderFactory(orderDB));
        map.put("GetAllOrders", new GetAllOrdersFactory(orderDB));
        map.put("GetOrder", new GetOrderFactory(orderDB));
        map.put("UpdateOrder", new UpdateOrderFactory(orderDB));

        return new CommandResolver(map);
    }

    private CustomerDB createCustomerDB(){
        return new CustomerDB();
    }

    private OrderDB createOrderDB(){
        return new OrderDB();
    }
}
