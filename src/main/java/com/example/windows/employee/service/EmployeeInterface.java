package com.example.windows.employee.service;


import com.example.windows.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.naming.NameAlreadyBoundException;
import java.util.List;
//@Component
public interface EmployeeInterface {
    ResponseEntity<Employee> save(Employee employee) throws NameAlreadyBoundException;

    ResponseEntity<List<Employee>> saveEmployeeMultipleRecords(List<Employee> employeeList);

    ResponseEntity<Employee> updateEmployeeById(Employee employee);
    ResponseEntity<Employee> getRecordsByDepartment(String name);

    ResponseEntity<Employee> fecthRecordByfirstLetter(String name);

    ResponseEntity<Employee> generatedepartmentEmployee();

    ResponseEntity<Employee> getDeatilsByDepartment(String department);

    ResponseEntity<Employee> deletRecordByID(Long id);


    ResponseEntity<Employee> findSecondMax();

    ResponseEntity<Employee> findSecondMaxEmpy(List<String> name);

    ResponseEntity<Employee> averageAndAbove();

    ResponseEntity<Employee> nonSalaries();

    ResponseEntity<Employee> groupEmployeesByDepartment();

    ResponseEntity<Employee> multipleTask(String code);

    // Page<Employee> paginationAndSorting(int page, int size, String sortBy, String sortDirection);
}
