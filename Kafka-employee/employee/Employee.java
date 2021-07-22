package com.srinivart.employee;

public class Employee {

    private String name;
    private String msg;

    public Employee() {
    }

    public Employee(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }


}
