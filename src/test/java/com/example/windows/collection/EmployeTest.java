package com.example.windows.collection;

import com.example.windows.employee.impl.EmployeeImpl;
import com.example.windows.employee.service.EmployeeInterface;
import com.example.windows.entity.Employee;
import com.example.windows.junit.TestMethods;
import com.example.windows.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EmployeTest {


    @Mock
    EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeImpl employeeService;

   // @Test
    /*public void deleteByIDTest() {
        Long id = 6L;
        Employee employee = new Employee(); // mock or real object
        employee.setId(id);

        Mockito.when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));
        ResponseEntity<Employee> response = employeeService.deletRecordByID(id);

//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Record not found with the given ID", response.getBody());

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("Record with ID '1' has been deleted.", response.getBody());
        Mockito.verify(employeeRepo).deleteById(id);
    }*/
// disable for tempory both below
    /*@Test
    public void deleteByID_RecordNotFound_Test() {
        Long id = 5L;

        Mockito.when(employeeRepo.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Employee> response = employeeService.deletRecordByID(id);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Record not found with the given ID", response.getBody());

        Mockito.verify(employeeRepo, Mockito.never()).deleteById(id);
    }*/
  //  In unit testing, you create one method per scenario — each test method should focus on just one specific behavior.

//    1. ✅ Valid ID → Record is found and deleted
//            java
//    Copy
//            Edit
//    @Test
//    public void deleteByID_RecordExists_Test() {
//        // Mock the repo to return the record
//        // Expect HttpStatus.ACCEPTED and success message
//    }

//2. ❌ Invalid ID → Record is NOT found
//    java
//            Copy
//    Edit
//    @Test
//    public void deleteByID_RecordNotFound_Test() {
//        // Mock the repo to return Optional.empty()
//        // Expect HttpStatus.BAD_REQUEST and not-found message
//    }


//    3. ️ Unexpected Error (optional) → Repo throws an exception
//    java
//            Copy
//    Edit
//    @Test
//    public void deleteByID_Exception_Test() {
//        // Mock repo to throw new RuntimeException("DB error")
//        // Expect exception or custom error handling
//    }

    TestMethods testMethods=new  TestMethods();
    @Test
    void   addvalues(){
      int result=testMethods.addValue(12,8);
    //  assertEquals(20,result);
      Assertions.assertEquals(20,result);
              System.out.println(result);
}}

