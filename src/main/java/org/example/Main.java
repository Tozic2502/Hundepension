package org.example;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        String name;
        int age;
        String breed;
        int weight;


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
}
