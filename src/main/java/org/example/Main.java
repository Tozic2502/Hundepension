package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String name;
        int age;
        String breed;
        int weight;

        VeterinarianDao vetDao = new VeterinarianDaoImpl();
        System.out.println("start");

        Scanner inScanner = new Scanner(System.in);
        String menuNavigator;
        System.out.println("Goddag Rosa.\nVælg en funktion\n1: Kunde\n2: Hund\n3: Dyrlæge");
        menuNavigator = inScanner.nextLine().toLowerCase();

        switch(menuNavigator)
        {
            case "Kunde","1":
                System.out.println("11: Se Kunder\n12: Opret Kunde");
                menuNavigator = inScanner.nextLine().toLowerCase();
                switch (menuNavigator) {
                    case "opret kunde":
                        break;
                    case "se kunde":
                        break;
                }
                break;

            case "hund","2":
                System.out.println("21: Se Hunde\n22: Opret Hund");
                menuNavigator = inScanner.nextLine().toLowerCase();
                HundDao dao = new HundDaoImpl();
                switch (menuNavigator){
                case "opret hund":
                    Hund Hund = new Hund();

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


                case "se hunde":

                    dao.readAllHund();
                    dao.readHund(inputInt("Skriv Hundens id"));
                    break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + menuNavigator);
                }
                break;
            case "dyrlæge","3":

                System.out.println("1: Se Dyrlæger\n2: Opret Dyrlæge");
                menuNavigator = inScanner.nextLine().toLowerCase();
                switch(menuNavigator)
                {
                    case "se dyrlæger","1":
                        vetDao.readAllVeterinarians();
                        break;

                    case "opret dyrelæge","2":
                        Veterinarian opretVet = new Veterinarian();
                        opretVet.setFldVetName(inputString("Skriv dyrlægens navn:"));
                        opretVet.setFldVetAdres(inputString("Skriv dyrlægens adresse:"));
                        opretVet.setFldVetTelephoneNumber(inputInt("Skriv dyrlægens telefonnummer:"));
                        vetDao.createVeterinarian(opretVet);
                        break;
                    default:
                        System.out.printf("invalid menu navn: %s\n");
                }
                break;


            default:
                System.out.printf("Invalid choice");
        }

        System.out.println("end");



        System.out.println("slut");

    }

    //Metode som tager inputs af typen string, for at følge DRY princippet
    public static String inputString (String prompt)
    {
       //Prepares an outputstring
        String outputString = "";

        //Flag to check whether any input has been entered
        Boolean isEmpty = outputString.isEmpty();

        //If isEmpty is true, loop runs
        while(isEmpty)
        {
            //Prints the user prompt
            System.out.println(prompt);

            //Readies a scanner and takes the user input
            Scanner inputScanner = new Scanner(System.in);
            outputString = inputScanner.nextLine();

            //When the string has input, returns the string.
            if (!isEmpty)
            {
                return outputString;
            }


        }
        return "Method is not working properly, please contact developer";
    }

    //Metode som tager inputs af typen int, for at følge DRY-princippet
    private static int inputInt(String prompt)
    {
        //Prepares an output integer
        int outputInt = 0;

        //Flag to check whether any input, not zero, has been entered
        Boolean isEmpty = outputInt==0;

        //If isEmpty is true, loop runs
        while(isEmpty)
        {
            //Prints the user prompt
            System.out.println(prompt);

            //Readies a scanner and takes the user input
            Scanner inputScanner = new Scanner(System.in);
            outputInt = inputScanner.nextInt();

            //If outputInt != 0, returns outputInt
            if (!isEmpty)
            {
                return outputInt;
            }


        }
        return 0;
    }

}