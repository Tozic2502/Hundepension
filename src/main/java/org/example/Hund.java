package org.example;

import java.util.Scanner;

public class Hund {
        String name;
        int age;
        String breed;
        Double weight;



    public void Hund() {
        Scanner scN = new Scanner(System.in);//Scanner to check inputs
        System.out.println("Enter the name of the Dog: ");
        name = scN.next();

        Scanner scA = new Scanner(System.in);//Scanner to check inputs
        System.out.println("Enter the age of the Dog: ");
        age = scA.nextInt();

        Scanner scB = new Scanner(System.in);//Scanner to check inputs
        System.out.println("Enter the breed of the Dog: ");
        breed = scB.next();

        Scanner scW = new Scanner(System.in);//Scanner to check inputs
        System.out.println("Enter the weight of the Dog in kg: ");
        weight = scW.nextDouble();

        System.out.printf(name + "\t" + "Age:" + age + "\t" + breed + "\t" + weight + "kg");


    }


}
