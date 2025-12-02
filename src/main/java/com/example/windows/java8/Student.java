package com.example.windows.java8;

import java.util.Objects;

public class Student {
    private String name;
    private String address;
    private long mobileNumber;
    private String collegename;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return mobileNumber == student.mobileNumber && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(collegename, student.collegename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, mobileNumber, collegename);
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long mobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String collegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public Student(String name, String address, long mobileNumber, String collegename) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.collegename = collegename;

    }
    public Student(){


    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", collegename='" + collegename + '\'' +
                '}';
    }
}
