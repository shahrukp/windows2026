package com.example.windows.collection_Lambda_2025;

import java.util.Objects;

public class EmployeObj  implements  Comparable<EmployeObj>{

    private String name;
    private String department;
    private Double salary;
    private String id;
    private String jobtitle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeObj that = (EmployeObj) o;
        return name.equals(that.name) && department.equals(that.department)
                && salary.equals(that.salary) && id.equals(that.id) && jobtitle.equals(that.jobtitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary, id, jobtitle);
    }

    @Override
    public String toString() {
        return "EmployeObj{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary='" + salary + '\'' +
                ", id='" + id + '\'' +
                ", jobtitle='" + jobtitle + '\'' +
                '}';
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String jobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public EmployeObj(String name, String department, Double salary, String id, String jobtitle) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = id;
        this.jobtitle = jobtitle;
    }


    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(EmployeObj o) {
        return o.id.compareTo(this.id()); // min salary  order
    }
}
