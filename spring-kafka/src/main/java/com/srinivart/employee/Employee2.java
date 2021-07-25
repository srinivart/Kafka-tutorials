package com.srinivart.employee;

public class Employee2 {

    private String name;

    public Employee2() {
    }

    public Employee2(String name) {
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
        return "Employee2{" +
                "name='" + name + '\'' +
                '}';
    }
}
