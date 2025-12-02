package com.example.windows.code.task;

import com.example.windows.entity.Employee;
import com.example.windows.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/api")
@RestController
public class FindHighesSecondEmpolyee {

        @Autowired
    EmployeeRepo employeeRepo;
    @GetMapping("/fetchs")
    public ResponseEntity<Employee> fincsecondHingheEmp(){
        List<Employee> employees = employeeRepo.findAll(); // fetch all from DB
        Employee secondHighest = employees.stream()
                .filter(e -> e.getSalary() != null )
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1) // skip the highest
                .findFirst() // pick the next one
                .orElse(null);
        return new ResponseEntity<>(secondHighest, HttpStatus.OK);

 }


    @GetMapping("/grp")
    public ResponseEntity<String> gropungByDepartments(){
        List<Employee> employees = employeeRepo.findAll(); // fetch all from DB
     Map<String,List<Employee>> r= employees.stream()
                .filter(e->e.getDepartment() !=null && e.getDepartment().equalsIgnoreCase("hr"))
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return new ResponseEntity<>("result" +r, HttpStatus.OK);

    }

}

