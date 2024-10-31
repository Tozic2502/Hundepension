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
        menuNavigator = inScanner.next();

        switch(menuNavigator)
        {
            case "Kunde","kunde","1":
                System.out.println("11: Se Kunder\n12: Opret Kunde");
                menuNavigator = inScanner.next();
                case "Opret Kunde","opret Kunde","Opret kunde":
                case "Se Kunder","se Kunde","Se kunde":

            case "Hund","hund","2":
                System.out.println("21: Se Hunde\n22: Opret Hund");
                menuNavigator = inScanner.next();
            case "Opret Hund","opret Hund","Opret hund":
            case "Se Hunde","se Hunde","Se hunde":
            case "Dyrlæge","dyrlæge","3":

                System.out.println("1: Se Dyrlæger\n2: Opret Dyrlæge");
                menuNavigator = inScanner.next();
                switch(menuNavigator)
                {
                    case "Se","Se Dyrlæge","1":
                        vetDao.readAllVeterinarians();

                    case "Opret Dyrelæge","Opret","2":
                        Veterinarian opretVet = new Veterinarian();
                        opretVet.setFldVetName(inputString("Skriv dyrlægens navn:"));
                        opretVet.setFldVetAdres(inputString("Skriv dyrlægens adresse:"));
                        opretVet.setFldVetTelephoneNumber(inputInt("Skriv dyrlægens telefonnummer:"));
                        vetDao.createVeterinarian(opretVet);
                }
        }

        System.out.println("end");

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

        HundDao dao = new HundDaoImpl();

        //dao.readHund(1);

        Hund d = new Hund(name, age, breed, weight);
        dao.createHund(d);

        dao.readAllHund();

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