package com.example.windows.repository;


import com.example.windows.entity.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee ,Long> {


    Employee findOneByname(String n);


   List<Employee> findEmployeeByName(String name);

    List<Employee> findEmployeesByName(String name);

    List<Employee> findBydepartment(String department);

    Employee findByName(String eName);


    Stream<Employee> findBysalary(double salarys);

    List<Employee> findOneBysalary(double salarys);

    List<Employee> findByNameIn(List<String> name); // use for list

    List<Employee> findAllBysalary(double ee);


    // Employee findByNameContainingIgnoreCase(Sort sort, PageRequest pageRequest);
}
