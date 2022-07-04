package com.resources;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll_No='" + roll_No + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Student(String name, String roll_No, String city) {
        this.name = name;
        this.roll_No = roll_No;
        this.city = city;
    }

    String name;
    String roll_No;
    String city;

    public String getName() {
        return name;
    }

    public String getRoll_No() {
        return roll_No;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll_No(String roll_No) {
        this.roll_No = roll_No;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
