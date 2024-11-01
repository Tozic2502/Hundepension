package org.example;

import org.example.view.Table;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class showInformation {
    static sqlConnetion sql = new sqlConnetion();
    static boolean connection = false;
    private static int selectedDog = 0;
    public static void main(String[] args) throws Exception {
        sql.setDatabase("dbDogCare");
        sql.setDestination("localhost");
        sql.setUsername("sa");
        sql.setPassword("1234");

        connection = sql.Connect();

        System.out.println("Main Menu > Show Information");
        System.out.println(" 0. Go back to Main Menu ");
        System.out.println(" 1. Show Customers Information");
        System.out.println(" 2. Show Dogs Information");


        int i = new Scanner(System.in).nextInt();
        switch (i) {
            case 0:
                Main.main(null);
                break;
            case 1:
                showCustomersInformation();
                break;

        }
    }
    public static void showCustomersInformation() {
        System.out.println("Main Menu > Show information > Customer information");
        System.out.println(" 0. go back to Main Menu ");
        System.out.println(" 1. Search by Telephonenumber");
        System.out.println(" 2. Search by Name");
        System.out.println(" ");
        int i = new Scanner(System.in).nextInt();
        switch (i) {
            case 1:
                System.out.printf("Enter Telephonenumber : ");
                int telephonenumber = new Scanner(System.in).nextInt();
                try {
                    if (connection) {
                        Table t = new Table(new String[]{"Telephonenumber", "Name", "E-Mail", "Address"}, sql.get("*", "tblCustomer", new String[]{"fldCustomerTelephoneNumber = " + telephonenumber}));
                        t.print();
                    } else {
                        System.out.println("Failed to connect to database");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case 2:
                System.out.printf("Enter Telephonenumber : ");
                String name = new Scanner(System.in).next();
                try {
                    if (connection && name != null || name != "") {
                        Table t = new Table(new String[]{"Telephonenumber", "Name", "E-Mail", "Address"}, sql.get("*", "tblCustomer", new String[]{"fldCustomerName = " + name}));
                        t.print();
                    } else {
                        System.out.println("Failed to connect to database");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
    }
    public static void showDogInformation() throws SQLException {
                System.out.println("Main Menu > Show information > Dog information");
                System.out.println(" 0. back ");
                System.out.println(" 1. Search by Name");
                System.out.println(" 2. Search by Owners Telephonenumber");
                System.out.println(" ");
                int i = new Scanner(System.in).nextInt();
                Table t = null;
                switch (i) {
                    case 1:
                        System.out.printf("Enter Name : ");
                        String name = new Scanner(System.in).next();
                        if (connection && name != null || name != "") {
                             t = new Table(new String[] {"Name", "Breed", "age", "breed", "weight", "ID"}, sql.get("fldName, fldBreed, fldAge, fldWeight fldOwnerID", "tblDog", new String[] {"where fldName= " + name +";"}));
                            t.print();

                        }
                        System.out.println("Please select Dog");
                        System.out.println("Dog");
                        int dogSelection = new Scanner(System.in).nextInt();
                        selectedDog = Integer.parseInt(t.get(dogSelection, 4));


                        case 2:
                            System.out.printf("Enter Name : ");
                            int OwnerID = new Scanner(System.in).nextInt();
                            if (connection && OwnerID != 0) {
                                t = new Table(new String[] {"Name", "Breed", "age", "breed", "weight", "ID"}, sql.get("fldName, fldBreed, fldAge, fldWeight fldOwnerID", "tblDog", new String[] {"where FK_fldOwnerID= " + OwnerID +";"}));
                                t.print();
                            }
                            System.out.println("Please select Dog");
                            System.out.println("Dog");
                            dogSelection = new Scanner(System.in).nextInt();
                            selectedDog = Integer.parseInt(t.get(dogSelection, 4));
                            break;
                            default:
                                System.out.println("Please select a valid option");
                                break;

                }



    }

    //select fldVaccineType, fldDateOfVaccination from tblVaccine inner join tblVet on tblVet.fldVetTelephoneNumber = tblVaccine.FK_fldVetID
    public static void showVaccineInfo() {
        System.out.println("Main Menu > Show information > Vaccine information");
        System.out.println(" ");
        Table t = new Table(new String[] {"Vaccine Type", "Date", "Doctor"}, sql.get("fldVaccineDate"))
    }
    public class DateConversion {
        public static void main(String[] args) {
            // Assume sqlDate is your java.sql.Date instance
            Date sqlDate = new Date(System.currentTimeMillis());

            // Convert to java.util.Date
            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

            System.out.println("SQL Date: " + sqlDate);
            System.out.println("Util Date: " + utilDate);
        }
    }








}
