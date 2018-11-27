package Controller.CommandResolver;

import Controller.CommandFactory.CommandFactory;
import Controller.CommandFactory.CustomerFactories.*;
import Model.CustomerDB;
import Model.OrderDB;

import java.util.HashMap;
import java.util.Map;

public class CommandResolver implements CommandFactoryResolver {
    private Map<String, CommandFactory> map;
    private CustomerDB customerDB;
    private OrderDB orderDB;

    public CommandResolver(CustomerDB customerDB, OrderDB orderDB){
        this.customerDB = customerDB;
        this.orderDB = orderDB;
        map = new HashMap<String, CommandFactory>();
        map.put("CreateCustomer", new CreateCustomerFactory(customerDB));
        map.put("DeleteAllCustomers", new DeleteAllCustomerFactory(customerDB));
        map.put("DeleteCustomer", new DeleteCustomerFactory(customerDB));
        map.put("GetAllCustomers", new GetAllCustomersFactory(customerDB));
        map.put("GetCustomer", new GetCustomerFactory(customerDB));
        map.put("UpdateCustomer", new UpdateCustomerFactory(customerDB));
        /**/
    }

    @Override
    public CommandFactory resolveCommandFactory(String commandName){
        return map.get(commandName);
    }
}
