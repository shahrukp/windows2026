package com.example.windows.controller;

import com.example.windows.entity.Employee;
import com.example.windows.streamapiimpl.StramImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/stream/apis/")
public class StreamController {


    //  @Autowired(required=true)
    // private Employee employee;

    @Autowired(required = true)
    private StramImpl stream_api;

    //Get list of employees whose salary > 50,000
    @GetMapping("list-employees")
    public List<Employee> fetchlistRecords() {
        List<Employee> result = stream_api.getEmployeeList().stream()
                .filter(e -> e.getSalary() != null && e.getSalary() > 50000)
                .collect(Collectors.toList());
        System.out.println("get list of employee !");

        return result;
    }

    // Group employees by department
    @GetMapping("group-employees_department")
    public String fetchemployeeByDepartment() {
        Map<String, List<Employee>> departments = stream_api.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        if (departments.isEmpty()) {
            System.out.print("list employee is empty");

        } else {
            departments.forEach((emp, dep) ->
                    System.out.print("the emp " + emp + " and the department " + dep));
        }
        return "record fecth see output in console !";

    }

    //Find the employee with the highest salary
    @GetMapping("highest_salary")
    public String highestSalary() {
        Optional<Employee> highest_salary = stream_api.getEmployeeList().stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        highest_salary.ifPresentOrElse(e -> System.out.print("Highest Paid: " + e),
                () -> System.out.print("list is empty !!"));

        return "see the console for the ouput !" + highest_salary;
    }

    //Get average salary by department
    @GetMapping("average")
    public String averageByDepartment() {
        Map<String, Double> averageby = stream_api.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        return "average salary by depratment" + averageby;

    }

    // Sort employees by salary in descending order
    @GetMapping("sortedEmployees")
    public String salaryDescendingOrder() {
        List<Employee> sortedEmployees = stream_api.getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        return "sortedEmployees salary by ascending order " + sortedEmployees;


    }

    // List all employee names in a single comma-separated string
    @GetMapping("single_comma")
    public String singleComma() {
        String res = stream_api.getEmployeeList().stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));

        return res;

    }

    // find occurence char
    @GetMapping("occurence")
    public String occurenceEachChar() {
        String str = "aabbddfrrcpp"; // first non repeating char

        Optional<Character> r = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst();


        return "output  sent to consloe !" + r;

    }

    //calculate the aveage for salary
    @GetMapping("average_calculate")
    public Double aveageCalculate() {
        return stream_api.getEmployeeList().stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));


    }


    //count each occurence
    @GetMapping("counts")
    public Map<String, Long> countEachocc() {
        String str = "aavvff";
        Map<String, Long> count = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(
                        f -> f,
                        Collectors.counting()));
        count.forEach((key, value) -> System.out.print(key + " ocurnece" + value));

        return count;

    }

    @GetMapping("get")
    public int addValue() {
        int a = 10;
        int b = 32;

        return a + b;
    }

    @GetMapping("even_number")
    public boolean  checkEvenNumber() {
        int a = 10;
        return a %  2 == 0;
    }





}