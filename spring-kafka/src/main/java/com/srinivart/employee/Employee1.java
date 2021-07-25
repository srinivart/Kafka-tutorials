package com.srinivart.employee;

public class Employee1 {

    String name;

    public Employee1() {
    }

    public Employee1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                '}';
    }
}
