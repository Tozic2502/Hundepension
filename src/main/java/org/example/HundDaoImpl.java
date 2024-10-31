package org.example;
import java.sql.*;

public class HundDaoImpl implements HundDao {

    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=dbDogCare";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "1234"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override
    public void createHund(Hund hund) throws Exception {
        String sql = "INSERT INTO tblDog(fldName, fldAge, fldBreed, fldWeight) VALUES (?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, hund.getName());
        pstmt.setInt(2, hund.getAge());
        pstmt.setString(3, hund.getBreed());
        pstmt.setInt(4, hund.getWeight());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Hund added successfully.");
        } else {
            System.out.println("Failed to add the Hund.");
        }
    }

    @Override
    public void readHund(int id) throws Exception{
        String sql = "SELECT * FROM tblDog WHERE fldID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Hund hund = new Hund();
            hund.setName(rs.getString(2));
            hund.setAge(rs.getInt(3));
            hund.setBreed(rs.getString(7));
            hund.setWeight(rs.getInt(8));

            System.out.println(hund.getName() + " "+ hund.getAge()+ " "+ hund.getBreed()+ " "+ hund.getWeight());
        } else {
            System.out.println("No Hund found with ID: " + id);
        }
    }

    @Override
    public void readAllHund() throws Exception{
        String sql = "SELECT fldName, fldAge, fldBreed, fldWeight FROM tblDog";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasHund = false;
        while (rs.next()) {
            hasHund = true;
            Hund hund = new Hund();
            hund.setName(rs.getString(1));
            hund.setAge(rs.getInt(2));
            hund.setBreed(rs.getString(3));
            hund.setWeight(rs.getInt(4));
            System.out.println(hund.getName()+hund.getBreed()+hund.getWeight()+" "+ hund.getAge());
        }
        if (!hasHund) {
            System.out.println("No departments found.");
        }
    }
}


