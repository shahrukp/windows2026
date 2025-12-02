package com.example.windows.employee.controller;


import com.example.windows.employee.service.EmployeeInterface;
import com.example.windows.entity.Employee;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameAlreadyBoundException;
import java.util.List;

@RequestMapping("/rest/api/")
@RestController
public class EmployeCntroller {

 @Lazy
    @Autowired(required=true)
    private EmployeeInterface employeeInterface;

    // create save object method  single records
        @PostMapping("/save/object")
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws NameAlreadyBoundException {
    return employeeInterface.save(employee);

}

// save multipls records
    @PostMapping("/save/listobject")
    public ResponseEntity<List<Employee>> saveEmployeeMultipleRecords(@RequestBody(required = false) List<Employee> employeeList) throws NameAlreadyBoundException {
        return employeeInterface.saveEmployeeMultipleRecords(employeeList);

    }


    //@PatchMapping("/update/records/by/{id}")
    @PatchMapping("/update/records/by/")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody(required =false) Employee employee) {
        return employeeInterface.updateEmployeeById(employee);
    }
    @GetMapping("/get/records/by/{name}") // by name
    public ResponseEntity<Employee> getRecordsByDepartment(@PathVariable String name) {
        return employeeInterface.getRecordsByDepartment(name);
    }

// fecth records by starting with  specific letter like s->shahruk,a->abhya b -> etc
    @GetMapping("/get/records/by/firstletter/{name}") // by name
    public ResponseEntity<Employee> fecthRecordByfirstLetter(@PathVariable String name) {
        return employeeInterface.fecthRecordByfirstLetter(name);
    }

    //Generate Department-Wise Employee Summary
    @GetMapping("/department") // by name
    public ResponseEntity<Employee> generatedepartmentEmployee() {
        return employeeInterface.generatedepartmentEmployee();
    }

    //Generate Department-Wise Employee Summary
    @GetMapping("/department/{department}") // by name
    public ResponseEntity<Employee> getDeatilsByDepartment(@PathVariable String department) {
        return employeeInterface.getDeatilsByDepartment(department);
    }

    //delete By id
    //Generate Department-Wise Employee Summary
    @DeleteMapping("/delete/record/{id}") // by name
    public ResponseEntity<Employee> deletRecordByID(@PathVariable Long id) {
        return employeeInterface.deletRecordByID(id);
    }

    @GetMapping("/say/hi/")
    public String sayMessage(){
        return "welcome";
    }



    //Pagination and Sorting
    // by name   GET /employees?page=1&size=5&sortBy=salary&sortDir=desc
//    @GetMapping("/pagination/sorting/{page}/{size}/{sortBy}/{sortDir}")
//    public Page<Employee> paginationAndSorting(@RequestParam(defaultValue = "0")  int page,
//                                               @RequestParam (defaultValue = "size") int size,
//                                               @RequestParam (defaultValue = "sortBy") String sortBy,
//                                               @RequestParam (defaultValue = "sortDir")String sortDirection) {
    //      return employeeInterface.paginationAndSorting(page, size, sortBy, sortDirection);
//    }



    // find second max salary emp and retrun as output

   // @GetMapping("/find/second/max/{name}")
   //public ResponseEntity<Employee> findSecondMaxEmpy(@PathVariable() String name){
    @GetMapping("/find/second/max/")
    // endpoint http://localhost:8080/rest/api/find/second/max/?name=tilu
    public ResponseEntity<Employee> findSecondMaxEmpy(@RequestParam(required = false)
                                                          List<String> name){

        return  employeeInterface.findSecondMaxEmpy(name);
    }


    @GetMapping("/find/second/max/emp/")
    public ResponseEntity<Employee> findSecondMax(){
        return  employeeInterface.findSecondMax();
    }


    // calcuale avergae and count emppoye >50 ,000

    @GetMapping("/average/above/")
    public ResponseEntity<Employee> averageAndAbove(){
        return  employeeInterface.averageAndAbove();
    }


    //Filter employees with non-null salaries
    @GetMapping("/non/salaries/")
    public ResponseEntity<Employee> nonSalaries(){
        return  employeeInterface.nonSalaries();
    }

    //Group employees by department
    @GetMapping("/by/department/")
    public ResponseEntity<Employee> groupEmployeesByDepartment(){
        return  employeeInterface.groupEmployeesByDepartment();
    }

    //Multipl task using code
    @GetMapping("/multiple/task/")
    public ResponseEntity<Employee> multipleTask( @RequestParam (required = false) String code){
        return  employeeInterface.multipleTask(code);
    }

}
