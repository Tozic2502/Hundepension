package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String name;
        int age;
        String breed;
        int weight;

        System.out.println("start");

        //Creates a scanner to take user input
        Scanner inScanner = new Scanner(System.in);
        //Creates a string used for navigating the menu
        String menuNavigator;
        //Prints the first menu options, more menu options would be added if we had more time
        System.out.println("Goddag Rosa.\nVælg en funktion\n1: Kunde\n2: Hund\n3: Dyrlæge");
        //Example of how we take input for the menu, regardless of upper/lower case
        menuNavigator = inScanner.nextLine().toLowerCase();

        //Switchcase bringing us to the user specified menu option
        switch(menuNavigator)
        {
            case "kunde","1":
                System.out.println("1: Opret Kunde\n2: Se Kunder");
                menuNavigator = inScanner.nextLine().toLowerCase();

                CustomerDao cdao = new CustomerDaoImpl();
                switch (menuNavigator)
                {
                    case "opret kunde","1":
                        Customer customer = new Customer();
                        customer.setName(inputString("Please input customer name:"));
                        customer.setAddress(inputString("Please input customer address:"));
                        customer.setPhoneNumber(inputInt("Please input customer phone number:"));
                        customer.setEmail(inputString("Please input customer email:"));
                        cdao.createCustomer(customer);
                        break;

                    case "se kunde","2":
                        cdao.readAllCustomer();
                        break;
                }
                break;

            case "hund","2":
                System.out.println("1: Se Hunde\n2: Opret Hund");
                menuNavigator = inScanner.next().toLowerCase();

                HundDao dao = new HundDaoImpl();

                switch (menuNavigator)
                {
                    case "se hunde","1":

                        dao.readAllHund();
                        dao.readHund(inputInt("Skriv Hundens id"));
                        break;

                    case "opret hund","2":

                        Hund hund = new Hund();

                        System.out.println("start");
                        Scanner scN = new Scanner(System.in);//Scanner to check inputs
                        System.out.print("Enter the name of the dog: ");
                        name = scN.next();
                        Scanner scA = new Scanner(System.in);//Scanner to check inputs
                        System.out.print("Enter the age of the dog: ");
                        age = scA.nextInt();
                        Scanner scB = new Scanner(System.in);//Scanner to check inputs
                        System.out.print("Enter the breed: ");
                        breed = scB.next();
                        Scanner scW = new Scanner(System.in);//Scanner to check inputs
                        System.out.print("Enter the weight of the dog: ");
                        weight = scW.nextInt();


                        Hund d = new Hund(name, age, breed, weight);
                        dao.createHund(d);

                        break;


                    default:
                        throw new IllegalStateException("Unexpected value: " + menuNavigator);
                }
                break;

            case "dyrlæge","3":
                System.out.println("1: Se Dyrlæger\n2: Opret Dyrlæge");
                menuNavigator = inScanner.next().toLowerCase();

                //Instantiates a new object of class VeterinarianDaoImpl of type VeterinarianDao
                VeterinarianDao vetDao = new VeterinarianDaoImpl();

                switch(menuNavigator)
                {
                    case "se dyrlæge","1":
                        //Calls a method from class VeterinarianDaoImpl to read vets from database and print
                        vetDao.readAllVeterinarians();
                        break;

                    case "opret dyrlæge","2":
                        //Creates a new object of class Veterinarian
                        Veterinarian opretVet = new Veterinarian();
                        //Calls method from Veterinarian class to set variables of opretVet, using method inputString()
                        opretVet.setFldVetName(inputString("Skriv dyrlægens navn:"));
                        opretVet.setFldVetAdres(inputString("Skriv dyrlægens adresse:"));
                        opretVet.setFldVetTelephoneNumber(inputInt("Skriv dyrlægens telefonnummer:"));
                        //Uses our vetDao object to create the entry in our database
                        vetDao.createVeterinarian(opretVet);
                        break;
                }
                break;

            default:
                System.out.printf("Invalid choice");

        }

        System.out.println("end");

    }

    //Method taking input of type String and returning it in an outputString variable
    public static String inputString (String prompt)
    {
       //Prepares an outputstring
        String outputString;

        //Flag to check whether any input has been entered
        Boolean isEmpty = true;

        //If isEmpty is true, loop runs
        while(isEmpty)
        {
            //Prints the user prompt
            System.out.println(prompt);

            //Readies a scanner and takes the user input
            Scanner inputScanner = new Scanner(System.in);
            outputString = inputScanner.nextLine();

            //Checks whether outputString is empty
            isEmpty = outputString.isEmpty();

            //When the string has input, returns the string.
            if (!isEmpty)
            {
                return outputString;
            }
        }
        return "Method is not working properly, please contact developer";
    }

    //Method taking input of type int and returning it in an outputInt variable
    private static int inputInt(String prompt)
    {
        //Prepares an output integer
        int outputInt;

        //Flag to check whether any input, not zero, has been entered
        Boolean isEmpty = true;

        //If isEmpty is true, loop runs
        while(isEmpty)
        {
            //Prints the user prompt
            System.out.println(prompt);

            //Readies a scanner and takes the user input
            Scanner inputScanner = new Scanner(System.in);
            outputInt = inputScanner.nextInt();

            //Checks whether input is 0
            isEmpty = outputInt==0;

            //If outputInt != 0, returns outputInt
            if (!isEmpty)
            {
                return outputInt;
            }


        }
        return 0;
    }

}