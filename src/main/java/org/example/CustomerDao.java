package org.example;

public interface CustomerDao {
    void readCustomer(String no) throws Exception;
    void readAllCustomer() throws Exception;
    void createCustomer(Customer customer) throws Exception;
}
