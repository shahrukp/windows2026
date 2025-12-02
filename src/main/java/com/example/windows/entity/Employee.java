package com.example.windows.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // or AUTO
    private Long  id;
    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private Double salary;


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @LastModifiedDate
    //@PreUpdate
    @Column(name = "updated_at")
   // @PreUpdate
    private LocalDateTime updatedAt;



    @Column(name = "age")
    private int age;

    @Column(name = "mobile", length = 12) //  inclding STD Code
    private String mobile;

    // constructor, getters, setters
    // Constructors
    public Employee( String name, String department,int age,String mobile, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.mobile = mobile;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Employee() {
    }

    // Getters
    public Long  getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    // ✅ Proper Setters
    public void setId(Long  id) {
        this.id = id;
    }

    public void setAge(Long  age) {
        this.age = Math.toIntExact(age);
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + mobile  + " -"+ age + " - "  + name + " - " + department + " - " + salary;

    }

}
