package org.example;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=dbDogCare";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "123456789"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override
    public void createCustomer(Customer customer) throws Exception {
        String sql = "INSERT INTO tblCustomer VALUES (?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, customer.getPhoneNumber());
        pstmt.setString(2, customer.getName());
        pstmt.setString(3, customer.getAddress());
        pstmt.setString(4, customer.getEmail());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Failed to add customer.");
        }
    }

    @Override
    public void readCustomer(String no) throws Exception{
        String sql = "SELECT * FROM Customer WHERE fldCustomerTelephoneNumber = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();

        Customer customer = new Customer();

        if (rs.next()) {
            customer.setPhoneNumber(rs.getInt(1));
            customer.setName(rs.getString(2));
            customer.setAddress(rs.getString(3));
            customer.setEmail(rs.getString(4));
            System.out.println(customer.getPhoneNumber() + " "+ customer.getName()+ " "+ customer.getAddress()+ " "+ customer.getEmail());
        } else {
            System.out.println("No customer found with ID: " + no);
        }
    }

    @Override
    public void readAllCustomer() throws Exception{
        String sql = "SELECT * FROM tblCustomer";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasCustomers = false;
        while (rs.next()) {
            hasCustomers = true;
            Customer customer = new Customer();
            customer.setPhoneNumber(rs.getInt(1));
            customer.setName(rs.getString(2));
            customer.setAddress(rs.getString(3));
            customer.setEmail(rs.getString(4));
            System.out.println(customer.getPhoneNumber()+" "+ customer.getName()+" "+customer.getAddress()+" "+ customer.getEmail() );
        }
        if (!hasCustomers) {
            System.out.println("No customers found.");
        }
    }
}


