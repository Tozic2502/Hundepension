package org.example;

import java.sql.*;

public class VeterinarianDaoImpl implements VeterinarianDao
{
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=dbDogCare";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "1234"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override
    public void createVeterinarian(Veterinarian veterinarian) throws Exception {
        String sql = "INSERT INTO tblVet VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, veterinarian.getFldVetTelephoneNumber());
        pstmt.setString(2, veterinarian.getFldVetName());
        pstmt.setString(3, veterinarian.getFldVetAdres());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Veterinarian added successfully.");
        } else {
            System.out.println("Failed to add the veterinarian.");
        }
    }

    @Override
    public void readVeterinarian(int fldVetTelephoneNumber) throws Exception{
        String sql = "SELECT * FROM tblVet WHERE fldVetTelephoneNumber = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, fldVetTelephoneNumber);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Veterinarian veterinarian = new Veterinarian();
            veterinarian.setFldVetTelephoneNumber(rs.getInt(1));
            veterinarian.setFldVetName(rs.getString(2));
            veterinarian.setFldVetAdres(rs.getString(3));
            System.out.printf(veterinarian.getFldVetName() + " "+ veterinarian.getFldVetAdres()+ " "+ veterinarian.getFldVetTelephoneNumber());
        } else {
            System.out.println("No veterinarian found with tlf. nr. " + fldVetTelephoneNumber);
        }
    }

    @Override
    public void readAllVeterinarians() throws Exception{
        String sql = "SELECT * FROM tblVet";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasVeterinarians = false;
        while (rs.next()) {
            hasVeterinarians = true;
            Veterinarian veterinarian = new Veterinarian();
            veterinarian.setFldVetTelephoneNumber(rs.getInt(1));
            veterinarian.setFldVetName(rs.getString(2));
            veterinarian.setFldVetAdres(rs.getString(3));
            System.out.println(veterinarian.getFldVetName().trim()+" "+ veterinarian.getFldVetAdres().trim()+" "+veterinarian.getFldVetTelephoneNumber());
        }
        if (!hasVeterinarians) {
            System.out.println("No veterinarians found.");
        }
    }
}