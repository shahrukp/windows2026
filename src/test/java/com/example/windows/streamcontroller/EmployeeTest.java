package com.example.windows.streamcontroller;

import com.example.windows.employee.impl.ApiResponse;
import com.example.windows.employee.impl.EmployeeImpl;
import com.example.windows.entity.Employee;
import com.example.windows.repository.EmployeeRepo;
import org.junit.jupiter.api.AfterAll;
import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.naming.NameAlreadyBoundException;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

public class EmployeeTest {


        @Mock
        private EmployeeRepo employeeRepo;

        @InjectMocks
        private EmployeeImpl employeeService;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
        }


        @Test
        public void testSaveEmployee() throws NameAlreadyBoundException {
            // Arrange
            Employee employee = new Employee();
            employee.setId(1l);
            employee.setName("John Doe");
            employee.setDepartment("HR");
            employee.setSalary(55000.89);
            System.out.println( "department () -> "  +employee.getDepartment() +"  name ->" +
            employee.getName() +" and  salary -> () " +employee.getSalary());

            // Tell Mockito to return this dummy employee when save is called
            when(employeeRepo.save(any(Employee.class))).thenReturn(employee);

            // Act: Call the save method
            ResponseEntity<Employee> response = employeeService.save(employee);

            // Assert: Check that the response is what we expect
            assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
            assertEquals(employee, response.getBody());
            verify(employeeRepo, times(1)).save(employee); // Ensure the save was called once
        }
}

