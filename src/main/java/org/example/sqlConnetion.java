package org.example;
import java.sql.*;
public class sqlConnetion {
    private String destination = null;
    private String username = null;
    private String password = null;
    private String database = null;
    private Connection connection = null;


    public void sqlConnection(String destination, String username, String password, String database) {
        this.destination = destination;
        this.username = username;
        this.password = password;
        this.database = database;

    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public void setPassword(String password) {
        this.password = password;

    }

    public void setDatabase(String database) {
        this.database = database;

    }

    public boolean Connect() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection("jdbc:sqlserver://"+ destination + ";portNumber=1433;databaseName="+ database, username, password);
            return true;
        } catch (Exception e) {
            System.out.println("Connetion failed");
            e.printStackTrace();
            return false;
        }

    }

    public String[][] get(String Data, String from, String[] args) throws SQLException {
        PreparedStatement c = connection.prepareStatement("SELECT count(*) from " + from + " " + args);
        ResultSet rsCount = c.executeQuery();

        PreparedStatement p = connection.prepareStatement("SELECT " + Data + " FROM " + from + " " + args);
        ResultSet rs = p.executeQuery();
        int rows = rsCount.getInt(1);
        int colums = rs.getMetaData().getColumnCount();
        String[][] output = new String[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                output[i][j] = rs.getString(j + 1);
            }
        }
        return output;
    }
    public int count(String Data, String from, String[] args) throws SQLException {
        PreparedStatement c = connection.prepareStatement("SELECT count("+ Data + ") from " + from + " " + args );
        ResultSet rs = c.executeQuery();
        rs.next();
        return rs.getInt(1);

    }

    public String[] getColumNames(String Data, String from, String[] args)throws SQLException {

        PreparedStatement p = connection.prepareStatement("SELECT " + Data + " FROM " + from + " " + args);
        ResultSet rs = p.executeQuery();
        String[] output = new String[rs.getMetaData().getColumnCount()];
        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
            output[i] = rs.getString(i + 1);

        }
        return output;
    }
}