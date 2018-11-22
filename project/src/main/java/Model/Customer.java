package Model;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String address;

    public Customer(int id, String name, String phone, String address){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}