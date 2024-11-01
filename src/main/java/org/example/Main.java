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
        //VeterinarianDao vetDao = new VeterinarianDaoImpl();

        System.out.println("start");

        Scanner inScanner = new Scanner(System.in);
        String menuNavigator;
        System.out.println("Goddag Rosa.\nVælg en funktion\n1: Kunde\n2: Hund\n3: Dyrlæge");
        menuNavigator = inScanner.nextLine().toLowerCase();

        switch(menuNavigator)
        {
            case "kunde","1":
                System.out.println("1: Se Kunder\n2: Opret Kunde");
                menuNavigator = inScanner.nextLine().toLowerCase();

                switch (menuNavigator)
                {
                    case "opret kunde","1":
                        break;
                    case "se kunde","2":
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

                        //Hund hund = new Hund();

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

                VeterinarianDao vetDao = new VeterinarianDaoImpl();

                switch(menuNavigator)
                {
                    case "se dyrlæge","1":
                        vetDao.readAllVeterinarians();
                        break;

                    case "opret dyrlæge","2":
                        Veterinarian opretVet = new Veterinarian();
                        opretVet.setFldVetName(inputString("Skriv dyrlægens navn:"));
                        opretVet.setFldVetAdres(inputString("Skriv dyrlægens adresse:"));
                        opretVet.setFldVetTelephoneNumber(inputInt("Skriv dyrlægens telefonnummer:"));
                        vetDao.createVeterinarian(opretVet);
                        break;
                }
                break;

            default:
                System.out.printf("Invalid choice");

        }

        System.out.println("end");
    }

    //Metode som tager inputs af typen string, for at følge DRY princippet
    public static String inputString (String prompt)
    {
       //Prepares an outputstring
        String outputString = "";

        //Flag to check whether any input has been entered
        boolean isEmpty = true;

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
            //if (!isEmpty)
            //{
            //    return outputString;
            //}


        }
        return outputString;
    }

    //Metode som tager inputs af typen int, for at følge DRY-princippet
    private static int inputInt(String prompt)
    {
        //Prepares an output integer
        int outputInt = 0;

        //Flag to check whether any input, not zero, has been entered
        boolean isEmpty = true;

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
            //if (!isEmpty)
            //{
            //    return outputInt;
            //}


        }
        return outputInt;
    }

}