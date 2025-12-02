package com.example.windows.collection;


import com.example.windows.employee.impl.EmployeeImpl;
import com.example.windows.entity.Employee;
import com.example.windows.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class EmployeeTestforSpy {

    @Spy
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeImpl employeeImpl;

    @Transactional
    @Rollback(false) //@Transactional tells Spring:

         //   "Wrap this method (or class) in a transaction. If something goes wrong (an exception), undo everything. If it works fine, save the changes."
    @Test
    public void SpyTest(){
        Employee employee =new Employee();
        employee.setName("sr");
        employee.setDepartment("Account");
        employee.setSalary(2345.67);
     employee= employeeRepo.save(employee); // insert data into db real

        Long userId = employee.getId();

        Assertions.assertTrue(employeeImpl.exists(userId)); // should exist

        employeeImpl.deleteUserById(userId); // real delete

        Assertions.assertFalse(employeeImpl.exists(userId)); // should be gone
    }




    }
