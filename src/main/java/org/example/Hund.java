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
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }


}
