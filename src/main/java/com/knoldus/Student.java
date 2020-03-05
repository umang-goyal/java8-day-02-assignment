package com.knoldus;

public class Student {
    int id;
    String name;
    int age;
    Address address;

    public Student(int id, String name, int age, Address address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

}
