package org.example;

public class Customer {

    private String name;
    private int phoneNumber;
    private String address;
    private String email;

    public Customer() {

    }

    public Customer(String name, int phoneNumber, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * Method to display customer details
     */
    public void dispalyCustomerInformation() {
        System.out.println("Customer Details:");
        System.out.println("Name: " + name);
        System.out.println("PhoneNumber: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
    }
}
