package com.example.windows.streamapiimpl;

import com.example.windows.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class StramImpl {
   public List<Employee> getEmployeeList() {
      List<Employee> list_records = Arrays.asList(
              new Employee( "Tilu", "HR", 28 , "9786543245", 95000.00),
              new Employee( "Tilu", "HR",   34 , "9674556323", 70000.00),
              new Employee("Tom", "CEO", 21 , "9674556323", 45000.00),
              new Employee("Jerry", "HR", 45 , "9674556323", 90000.00),
              new Employee("Toy", "CEO", 20 , "8877654324", 85000.00),
              new Employee("Tilu", "Worker",  45 , "7788665544", 25000.00));

      return list_records;
   }

}