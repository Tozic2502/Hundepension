package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception
    {
        System.out.println("start");

        VeterinarianDao vet = new VeterinarianDaoImpl();

        vet.readVeterinarian(1);

        vet.readAllVeterinarians();

        Veterinarian vet1 = new Veterinarian(88443366, "Jørgensen Dyrlæge", "Storegade 17");

        vet.createVeterinarian(vet1);

        vet.readAllVeterinarians();

        System.out.println("end");


    }
}