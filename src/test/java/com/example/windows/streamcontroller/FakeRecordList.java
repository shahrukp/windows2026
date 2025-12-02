package com.example.windows.streamcontroller;

public class FakeRecordList {

    String name;
    int salary;

    FakeRecordList(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " (" + salary + ")";
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }


}
