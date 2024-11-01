package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=TH;portNumber=1433;databaseName=sample";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "123456"; // replace with your password


    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }


    public static void main(String[] args) throws Exception{
        System.out.println("start");
        Connection conn = getConnection();

        /*
        DepartmentDao dao = new DepartmentDaoImpl();

        dao.readDepartment("d1");

        Department d = new Department("d4","fishing","New York");
        dao.createDepartment(d);

        dao.readAllDepartments();
        */
        System.out.println("slut");
    }
}