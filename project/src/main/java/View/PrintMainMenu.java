package View;

public class PrintMainMenu {
    public void printMenu(){
        System.out.println
                ("(Write 'help' to get a command-list)\n"+
                        "(Write 'exit' to complete the program)");
    }

    public void printCustomerCommandList(){
        System.out.println
                ("1) CreateCustomer id=<id>; name=<name>; phone=<phone>; address=<address>; " +
                        "\n\tto create new customer");
        System.out.println
                ("2) DeleteAllCustomers" +
                        "\n\tto delete all customer");
        System.out.println
                ("3) DeleteCustomer id=<id>;" +
                        "\n\tto delete customer by id");
        System.out.println
                ("4) GetAllCustomers" +
                        "\n\tto show all customers");
        System.out.println
                ("5) GetCustomer id=<id>;" +
                        "\n\tto show customer by id");
        System.out.println
                ("6) UpdateCustomer id=<id>; ?name=<name>; ?phone=<phone>; ?address=<address>;" +
                        "\n\tto update customer by id" +
                        "\n\t(? - optional argument)");
    }

    public void printOrderCommandList(){

    }
}
