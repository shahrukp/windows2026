package com.example.windows.code.task;

import java.util.Objects;

public class Compartoresss {

    int id;
    String name;

    long mobilenumber;

    double marks;

    String department;

    Double salary;

    Compartoresss(int id, String name, long mobilenumber, double marks ,String department,
                  Double salary) {
        this.id = id;
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.marks = marks;
        this.department = department;
        this.salary = salary;

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Compartoresss{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilenumber=" + mobilenumber +
                ", marks='" + marks + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compartoresss that = (Compartoresss) o;
        return id == that.id && mobilenumber == that.mobilenumber && salary == that.salary && Objects.equals(name, that.name) && Objects.equals(marks, that.marks) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobilenumber, marks, department, salary);
    }

    /**
     *
     */
    public Compartoresss() {

    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long mobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(long mobilenumber) {
        this.mobilenumber = mobilenumber;
    }



    public String department() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double salary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public double marks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
