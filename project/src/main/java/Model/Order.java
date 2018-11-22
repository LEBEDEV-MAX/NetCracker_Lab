package Model;

public class Order {
    private int customerID;
    private int orderID;
    private String date;
    private int sum;

    public Order(int customerID, int orderID, String date, int sum){
        this.customerID = customerID;
        this.orderID = orderID;
        this.date = date;
        this.sum = sum;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getDate() {
        return date;
    }

    public int getSum() {
        return sum;
    }
}
