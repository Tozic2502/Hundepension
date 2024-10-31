package org.example;


import java.util.Scanner;

public class Hund {
        private String name;
        private int age;
        private String breed;
        private int weight;
        private int id;

    public Hund(String name, int age, String breed, int weight) {;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;

        System.out.printf(name + "\t" + "Age:" + age + "\t" + breed + "\t" + weight + "kg\n");


    }

    public Hund() {

    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        Scanner scN = new Scanner(System.in);//Scanner to check inputs

        this.name = scN.next();
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        Scanner scA = new Scanner(System.in);//Scanner to check inputs

        this.age = scA.nextInt();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        Scanner scB = new Scanner(System.in);//Scanner to check inputs

        this.breed = scB.next();
    }
    public void setWeight(int weight){
        Scanner scW = new Scanner(System.in);

        this.weight = scW.nextInt();
    }
    public int getWeight(){
        return weight;
    }


}
