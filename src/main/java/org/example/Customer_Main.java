package org.example;

import java.util.Scanner;

public class Customer_Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        /*
         * Get customer details from user
         */

        System.out.println("Enter customer's name");
        String name = sc.nextLine();

        System.out.println("Enter customer's address");
        String address = sc.nextLine();

        System.out.println("Enter customer's phone number");
        int phone = sc.nextInt();

        System.out.println("Enter customer's email");
        String email = sc.next();

        /*
         * Create a new customer
         */
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhoneNumber(phone);
        customer.setEmail(email);

        CustomerDao showDao = new CustomerDaoImpl();
        showDao.createCustomer(customer);

        /*
         * Display the customer details
         */
        customer.dispalyCustomerInformation();

    }
}
