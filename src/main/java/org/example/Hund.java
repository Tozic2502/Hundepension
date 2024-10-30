package org.example;

import java.util.Scanner;

public class Hund {
        private String name;
        private int age;
        private String breed;
        private int weight;
        private int id;

    public void Hund(String name, int age, String breed, int weight) {
        Scanner scN = new Scanner(System.in);//Scanner to check inputs
        this.name = scN.next();
        Scanner scA = new Scanner(System.in);//Scanner to check inputs
        this.age = scA.nextInt();
        Scanner scB = new Scanner(System.in);//Scanner to check inputs
        this.breed = scB.next();
        Scanner scW = new Scanner(System.in);//Scanner to check inputs
        this.weight = scW.nextInt();

        System.out.printf(name + "\t" + "Age:" + age + "\t" + breed + "\t" + weight + "kg");


    }

    public Hund() {

    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        Scanner scN = new Scanner(System.in);//Scanner to check inputs
        System.out.println("Enter the name of the Dog: ");
        this.name = scN.next();
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        Scanner scA = new Scanner(System.in);//Scanner to check inputs
        System.out.println("Enter the age of the Dog: ");
        this.age = scA.nextInt();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        Scanner scB = new Scanner(System.in);//Scanner to check inputs
        System.out.println("Enter the breed of the Dog: ");
        this.breed = scB.next();
    }
    public void setWeight(int weight){
        Scanner scW = new Scanner(System.in);
        System.out.println("Enter the weight of the Dog: ");
        this.weight = scW.nextInt();
    }
    public int getWeight(){
        return weight;
    }
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }

}
