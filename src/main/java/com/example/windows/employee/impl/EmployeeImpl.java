package com.example.windows.employee.impl;

import com.example.windows.custommessage.NameAlreadyExxitException;
import com.example.windows.employee.service.EmployeeInterface;
import com.example.windows.entity.Employee;
import com.example.windows.globleexception.MultipleRecordFailedToUpload;
import com.example.windows.repository.EmployeeRepo;
import com.example.windows.streamapiimpl.StramImpl;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;
import java.awt.geom.QuadCurve2D;
import java.awt.print.Pageable;
import java.security.cert.CollectionCertStoreParameters;
import java.security.interfaces.DSAPublicKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeImpl implements EmployeeInterface {

    @Autowired(required = true)
    @Lazy
    private EmployeeRepo employeeRepo;

    @Autowired
    @Lazy
    private StramImpl stramimpl;




    // find my mobileNumber
    public String findByMobileNumber(){
       List<Employee> employee= employeeRepo.findAll();
          String r= employee.stream()
               .map(Employee::getMobile)
               .filter(e->e !=null && !e.isEmpty())
               .findFirst()
               .orElse("no records is avilable in db");

        return "the recoreds are : " +r;

    }

    @Override

    // validate username if aalredy exist retrun false/message
    public ResponseEntity save(Employee employee) throws NameAlreadyBoundException {
        Employee emp1 = new Employee();
        // String n= emp1.getName();
        Employee existingEmployee = employeeRepo.findOneByname(employee.getName());
        if (existingEmployee != null) {
            throw new NameAlreadyExxitException(" Name already present! " + existingEmployee.getName());
        } else {
            Employee saved = employeeRepo.save(employee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(saved);
        }
        // return new ResponseEntity<>( emp ,"employee has been saved !" , HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<Employee>> saveEmployeeMultipleRecords(List<Employee> employeeList) {


        try {
            // Use passed list or fallback to dummy data
            List<Employee> emp = (employeeList == null || employeeList.isEmpty())
                    ? stramimpl.getEmployeeList()
                    : employeeList;

            // Save the records
            List<Employee> savedRecords = employeeRepo.saveAll(emp);

            // Return saved list
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedRecords);

        } catch (Exception e) {
            throw new MultipleRecordFailedToUpload("Something went wrong! " + HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param
     * @param employee
     * @return
     */
    @Override
    public ResponseEntity<Employee> updateEmployeeById(Employee employee) {

        Long id = employee.getId();
// when id is long
        if (id == null || id < 0) {
            return new ResponseEntity("Please provide a valid ID.", HttpStatus.BAD_REQUEST);
        }
        Optional<Employee> opt = employeeRepo.findById(id);

//        Optional<Employee> validEmployee = opt.filter(e -> e.getId() == null);
//        validEmployee.orElseGet( ()-> return new ResponseEntity("Please provide a valid ID.", HttpStatus.BAD_REQUEST));

// when user  have passed unlknow  id   then returnthis to user
        if (opt.isEmpty()) {
            return new ResponseEntity("Employee not found with the given ID.", HttpStatus.NOT_FOUND);

        }

        if (opt.isPresent()) {
            // Employee emp=new Employee();
            Employee existingEmployee = opt.get();
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            employeeRepo.save(existingEmployee);
            //return ResponseEntity.ok(updatedEmployee);
            return new ResponseEntity("records has been  updated ", HttpStatus.ACCEPTED);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @param
     * @param name
     * @return
     */
    @Override
    public ResponseEntity<Employee> getRecordsByDepartment(String name) {

//        try {
//            // Find all employees matching the given name (or department - depending on your method's intent)
//            List<Employee> employees = employeeRepo.findEmployeeByName(name);
//
//            // Check if the list is empty or null
//            if (employees == null || employees.isEmpty()) {
//                return new ResponseEntity("No employees found with the given name", HttpStatus.NOT_FOUND);
//            }
//
//            // Filter employees whose names start with 'S' (or any desired letter)
//            List<Employee> filteredEmployees = employees.stream()
//                    .filter(e -> e.getName() != null && e.getName().startsWith("S"))
//                    .collect(Collectors.toList());
//
//            if (filteredEmployees.isEmpty()) {
//                return new ResponseEntity("No employees found starting with the letter 'S'", HttpStatus.NOT_FOUND);
//            }
//
//            return new ResponseEntity(filteredEmployees, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        try {
            List<Employee> employee = employeeRepo.findEmployeeByName(name);

            if (employee != null) {
                Optional<Employee> opt = employee.stream().filter(e -> e.getName().startsWith("S"))
                        .findAny();
                return new ResponseEntity(opt, HttpStatus.OK);
            }
            if (employee != null) {
                return new ResponseEntity(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity("Employee not found", HttpStatus.NOT_FOUND);
            }
        } catch (NonUniqueResultException e) {
            List<Employee> employees = employeeRepo.findEmployeesByName(name);
            return new ResponseEntity(employees, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        /**
         * @param id
         * @return
         */


    }

    /**
     * @param name
     * @return
     */
    @Override
    public ResponseEntity<Employee> fecthRecordByfirstLetter(String name) { ///Tom
        try {
            List<Employee> allRecords = employeeRepo.findAll(); // assuming this gives all employees
            if (name.startsWith(name)) {
                List<Employee> filteredRecords = allRecords.stream()
                        .filter(e -> e.getName() != null && !e.getName().isEmpty())
                        .filter(e -> e.getName().startsWith(name.toUpperCase().toUpperCase()))
                        .collect(Collectors.toList());

                if (filteredRecords.isEmpty()) {
                    return new ResponseEntity("records not found ", HttpStatus.NOT_FOUND);
                }// else part
                return new ResponseEntity(filteredRecords, HttpStatus.OK);
            }

        } catch (DataAccessException dataAccessException) {
            return new ResponseEntity(dataAccessException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    /**
     * @param \
     * @return
     */
    @Override
    public ResponseEntity<Employee> generatedepartmentEmployee() {
        List<Employee> findAll = employeeRepo.findAll();
        Map<String, Double> departmentandsize = findAll.stream()
                .filter(e -> !e.getDepartment().isEmpty())
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        // departmentandsize.forEach((dep , value) ->System.out.println(dep +"and average" +value));

        Map<String, Long> nameCount = findAll.stream().filter(e -> e.getName() != null)
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.counting()));

        Map<String, Double> aeverageSalary = findAll.stream().filter(e -> e.getName() != null)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));


        Map<String, Map<String, List<Employee>>> empName = findAll.stream()
                .filter(e -> e.getName() != null)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(Employee::getName)));


//{
//  "department": "Engineering",
//  "averageSalary": 85000.00,
//  "employeeCount": 4,
//  "employees": ["Alice", "Bob", "Charlie", "Dana"],
//  "topEarner": "Charlie"
//}
        //  return  "result " +nameCount ,+departmentandsize;
        return new ResponseEntity(empName, HttpStatus.ACCEPTED);
    }

    /**
     * @param department
     * @return
     */
    @Override
    public ResponseEntity<Employee> getDeatilsByDepartment(String department) { //Account

        Employee employee=new Employee();
       List<Employee> findByDepartment=employeeRepo.findBydepartment(department.toUpperCase().toLowerCase());

//        if (findByDepartment.stream().anyMatch(employee -> employee.getDepartment() == null || employee.getDepartment().isBlank())) {
//            // handle the case where any employee has a null or blank department
//        }
     if(findByDepartment==null || findByDepartment.isEmpty()){
       String messagae=String.format("department '%s' not found", department);
         return  new ResponseEntity(messagae,HttpStatus.NOT_FOUND);
     }
       return new ResponseEntity(findByDepartment,HttpStatus.BAD_REQUEST);

}

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Employee> deletRecordByID(Long id) {

      Optional<Employee> deletedByID=employeeRepo.findById(id);
      if(!deletedByID.isPresent()){
          String message=String.format("record not found '%d' ! " ,id);
          return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
      }
      employeeRepo.deleteById(id);
          String mesage = String.format("Record with ID '%d' has been deleted.", id);
          return new ResponseEntity(mesage ,HttpStatus.ACCEPTED);
    }

    /**
     * @param
     * @return
     */
    @Override
    public ResponseEntity<Employee> findSecondMaxEmpy( List<String> name) {
      // hanlde null values if user miss to pass

        if (name == null || name.isEmpty()) {
            return new ResponseEntity("Invalid name provided", HttpStatus.BAD_REQUEST);
        }
       List<Employee> checkName=employeeRepo.findByNameIn(name); // In for as list of records
     // fecth from db if presnt

        if(!(checkName.isEmpty())){
            return new ResponseEntity(checkName, HttpStatus.ACCEPTED);
        }else{
            // else retrun of record not prestm
            return new ResponseEntity("no record found ", HttpStatus.BAD_GATEWAY);
        }
       }

    /**
     * @return
     */
    @Override
    public ResponseEntity<Employee> averageAndAbove() {

        // using java 8
        // > 50000  fecth all emo
           List<Employee> employeeList=employeeRepo.findAll();
    //Both conditions must be true for the whole expression to be true. for &&
         Long count=employeeList.stream()
                 .filter(e->e.getSalary()!=null && e.getSalary()>50000)
                 .count();
               //.collect(Collectors.counting());

        if(count==null){
            return new ResponseEntity("list is empty ",HttpStatus.ACCEPTED);

        }

        // now working on average
        // using stream api approvoch
             Double aevrage=employeeList.stream()
                        .filter(e->e.getSalary() !=null)
                       // .map(Employee::getSalary)
                        .collect(Collectors.averagingDouble(Employee::getSalary));
              //.collect(Collectors.toList());

        // using java old approch

        Employee employee=new Employee();

     List<Employee>  employeess =employeeRepo.findAll();

      List<Double> salrys=  employeess.stream()
                .filter(e->e.getSalary() !=null)
                .map(Employee::getSalary)
                .collect(Collectors.toList());
     // System.out.println("..................." +salrys);


      // uisng old approch
        Double sum=0.0;
        int counts=0;
        for(Employee emp :employeess){
            if(emp.getSalary()!=null){
               sum+=emp.getSalary();
               counts++;
                System.out.println( "salary only " +emp.getSalary());
            }
        }
        System.out.println("counts " +counts);
        System.out.println("sum " +sum);
        System.out.println("average " +sum/counts);






            return new ResponseEntity(aevrage,HttpStatus.ACCEPTED);
        }

    /**
     * @return
     */
    @Override
    public ResponseEntity<Employee> nonSalaries() {


        List<Employee>  employeess =employeeRepo.findAll();

        // using java 8 stream and lambda

     List <Employee> nonsalaries= employeess.stream()
                .filter(employee -> employee.getSalary() !=null)
                .collect(Collectors.toList());

       // Return employees with salary above average
      Double averageSalary = employeess.stream()
                .filter(e->e.getSalary()!=null)
                .collect(Collectors.averagingDouble(Employee::getSalary));

        double salary=0.0;
        List<Employee> averageSalaries=new ArrayList();
           for( Employee em:employeess){
                if(em.getSalary() !=null && em.getSalary()>averageSalary){
                    averageSalaries.add(em);
                }
           }
        if(!averageSalaries.isEmpty()){
            return new ResponseEntity(averageSalaries,HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity("averageSalaries-no one above average",HttpStatus.BAD_REQUEST);

        }

       // return new ResponseEntity(averageSalary ,HttpStatus.ACCEPTED);
    }

    /**
     * @return
     *///
    //Group employees by department
    @Override
    public ResponseEntity<Employee> groupEmployeesByDepartment() {

        Employee em =new Employee();
        //Groupemployeesbydepartment
    List<Employee> Groupemployeesbydepartment=employeeRepo.findAll();
     Map<String, List<Employee>> Groupemployeesbydepartment1= Groupemployeesbydepartment.stream()
                .filter(e->e.getDepartment() !=null )
                .collect(Collectors.groupingBy(
                       Employee::getDepartment,
                        Collectors.toList()));

     // Find the second highest paid employee
      Optional<Employee>  secondHigestPaidEmployee= Groupemployeesbydepartment.stream()
                .filter(r->r.getSalary()!=null)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();

        if(secondHigestPaidEmployee.isPresent()) {
            return new ResponseEntity(secondHigestPaidEmployee.get(), HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity(Groupemployeesbydepartment1,HttpStatus.OK);
//                .forEach(
//                grp->System.out.println(grp),
//                System.out.println("department is empty "));

    }

    /**
     * @param code
     * @return
     */
    @Override
    public ResponseEntity<Employee> multipleTask(String code) {
      List<Employee> useForRandomTask=employeeRepo.findAll();
String codePass="";
     switch (code){
         case  "each_dep" :
             //  Find the highest salary in each department  //  each_dep
             Map<String, Optional<Employee>> hp= useForRandomTask.stream()
                     //Both conditions must be true for the whole expression to be true. for &&
                     .filter(r->r.getSalary()!=null  && r.getDepartment() !=null)
                     .collect(Collectors.groupingBy(
                             Employee::getDepartment,
                             Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
             return  new ResponseEntity(hp,HttpStatus.OK);

         case  "each_dep_old" :
              //  Find the highest salary in each department  //  each_dep
             Double max=0.0; // suppose max salary
             Map<String, Employee> maps=new HashMap<>();
            for(Employee emp :useForRandomTask){
                if(emp.getSalary()!=null && emp.getDepartment() !=null) {
                   String department=emp.getDepartment();
                  Employee currentMax= maps.get(department);

                  if(currentMax==null ||  emp.getSalary() >currentMax.getSalary()){
                      maps.put(department,emp);
                  }

                }
         }

             return new ResponseEntity(maps,HttpStatus.ACCEPTED);



         case "sort_emp_alph" :
                 // Get the list of employee names sorted alphabetically  // sort_emp_alph
                 List<Employee>  sortByAlphabetically = useForRandomTask.stream()
                         .filter(t->t.getName()!=null)
                         .sorted(Comparator.comparing(Employee::getName).reversed()) // asc des
                         .collect(Collectors.toList());
             return  new ResponseEntity(sortByAlphabetically ,HttpStatus.ACCEPTED);

         case "sort_emp_alph_old" :

              // Get the list of employee names sorted alphabetically  // sort_emp_alph
             List<Employee> listOf =new ArrayList();
             for(Employee employee :useForRandomTask){
                 if(employee.getName() !=null){
                     listOf.add(employee);
                 }
                 //listOf.sort(Comparator.comparing(Employee::getName));
                 Collections.sort(listOf, new Comparator<Employee>() {
                     @Override
                     public int compare(Employee o1, Employee o2) {
                         return o2.getName().compareTo(o1.getName());
                     }
                 });

             }
             return  new ResponseEntity(listOf ,HttpStatus.ACCEPTED);




         //5️⃣ Check if any employee earns exactly 1,00,000    // equale_earns_100000
         case "equale_earns_100000" :
             Double targetValue =100000.0;
          List<Employee> equale_earns_100000= useForRandomTask.stream()
                     .filter(p->p.getSalary() !=null && p.getSalary()==targetValue)
                     .collect(Collectors.toList());
             if(!equale_earns_100000.isEmpty()){
                 return  new ResponseEntity(equale_earns_100000 ,HttpStatus.ACCEPTED);
             }else{
                 return  new ResponseEntity("no , employee earns exactly 1,00,000 " ,HttpStatus.BAD_GATEWAY);

             }
         case "equale_earns_100000_old" :
             Double threshold = 20000.0;
             for(Employee employee:useForRandomTask){
                 if(employee.getSalary()!=null && threshold.equals(employee.getSalary())){
                         return  new ResponseEntity(employee ,HttpStatus.ACCEPTED);
                     }

             }
             return new ResponseEntity("No employee earns exactly 20,000", HttpStatus.NOT_FOUND);


         //ind average salary per department  avr_per_dep
         case "avr_per_dep":
      Map<String,Double>  avr_per_dep=  useForRandomTask.stream()
                     .filter(w->w.getSalary()!=null)
                     .collect(Collectors.groupingBy(
                             Employee::getDepartment,
                             Collectors.averagingDouble(Employee::getSalary)));

             return  new ResponseEntity(avr_per_dep ,HttpStatus.ACCEPTED);


         case "partiton_emp":
         //Partition employees into two groups: salary > 50000 and <= 50000   //  partiton_emp
                Double targetValues=50000.0;
             Map<Boolean ,List<Employee>>  partiton_emp= useForRandomTask.stream()
                         .filter(w->w.getSalary()!=null)
                         .collect(Collectors.partitioningBy( w->
                                 w.getSalary()>targetValues));

// partition agian
                List<Employee> truesforabove=partiton_emp.get(true);
                 List<Employee> falsesforabove=partiton_emp.get(false);
               //  List<Employee> listOfparition =new ArrayList();
             Map<String, List<Employee>> listOfparition = new HashMap<>();

             listOfparition.put("above 50000" , truesforabove);
             listOfparition.put("below 50000",falsesforabove);

             return new ResponseEntity(listOfparition, HttpStatus.ACCEPTED);

         //Find employees hired in the last 6 months //    emp_hired_last_6m
         case "emp_hired_last_6m":
             LocalDateTime sixMonthsAgo = LocalDate.now().minusMonths(6).atStartOfDay();

             List<Employee> emp_hired_last_6m= useForRandomTask.stream()
                     .filter(q->q.getName() !=null && q.getCreatedAt() !=null)
                  .filter(f -> f.getCreatedAt().isAfter(sixMonthsAgo))
                     .collect(Collectors.toList());

             if(!emp_hired_last_6m.isEmpty()){
                 return new ResponseEntity(emp_hired_last_6m, HttpStatus.OK);
             }else {
                 return new ResponseEntity("No employee has been hired in the past 6 months ", HttpStatus.NOT_FOUND);

             }
         case "con_emp_list_map":
            //convert list of employees to Map<id, name // con_emp_list_map
        Map<Long,String> con_emp_list_map= useForRandomTask.stream()
                     .filter(e->e.getName()!=null)
                .collect(Collectors.toMap(
                        Employee::getId,
                         e->String.format(
                                 "Name: %s, Salary: %.2f, Dept: %s, Mobile: %s, CreatedAt: %s",
                                 e.getName(),
                                 e.getSalary(),
                                 e.getDepartment(),
                                 e.getMobile(),
                                 e.getCreatedAt())
//                        Employee::getName,
//                        Employee::getSalary,
//                        Employee::getDepartment,
//                        Employee::getMobile,
//                        Employee::getCreatedAt
                ));
             return new ResponseEntity(con_emp_list_map, HttpStatus.NOT_FOUND);

         case "max_emp_by_salary":
             Double maxSalary=0.0;
             for( Employee employee:useForRandomTask){
                 if(employee.getSalary()!=null && maxSalary < employee.getSalary()){
                  Double maxSalarys = employee.getSalary();
                  maxSalary=maxSalarys;


                 }
             }
             return new ResponseEntity(maxSalary, HttpStatus.NOT_FOUND);

        //find the longest-serving employee (oldest join date)
             //longest_serving
         case "longest_serving":
            Optional<Employee> longest_serving =useForRandomTask.stream()
                     .filter(a->a.getName()!=null && a.getCreatedAt()!=null)
                     .min(Comparator.comparing(Employee::getCreatedAt));
                     //.collect(Collectors.toList());

             if(longest_serving.isPresent()){
                 return new ResponseEntity("longest_serving" +longest_serving,HttpStatus.ACCEPTED);

             }else {
                 return new ResponseEntity("no longest_serving emp found " ,HttpStatus.ACCEPTED);
             }


             //Count employees per department and sort departments by count (descending)
           //  Challenge: Combine grouping and sorting
             //Tag: emp_count_sorted_dep

         case "emp_count_sorted_dep":
         Map<String ,Long>  emp_count_sorted_dep= useForRandomTask.stream()
                     .filter(r->r.getDepartment()!=null && r.getName() !=null)
                // .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                     .collect(Collectors.groupingBy(
                             Employee::getDepartment,
                             Collectors.counting()));

        // Collections.sort(Comparator.comparingDouble(a,b) ->b+a);
             Map<String, Long> sortedMap = emp_count_sorted_dep.entrySet().stream()
                     .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                     .collect(Collectors.toMap(
                             Map.Entry::getKey,
                             Map.Entry::getValue,
                             (e1, e2) -> e1,
                             LinkedHashMap::new // maintains order
                     ));

         return new ResponseEntity(sortedMap ,HttpStatus.ACCEPTED);



//         Convert employee list to Map<Department, List<Employee>> only for salaries > 60,000
//      Challenge: Filtering + grouping
//         Tag: high_earners_by_dep


         case "high_earners_by_dep":
        Map<String ,List<Employee>> high_earners_by_dep=   useForRandomTask.stream()
                     .filter(r->r.getSalary() !=null  &&  r.getSalary() > 60000.0 )
                     .collect(Collectors.groupingBy(
                             r -> {
                                 String dep = r.getDepartment();
                                 return (dep == null || dep.trim().isEmpty()) ? "No Department" : dep;
                             },
                             Collectors.toList()));
         Map<String , List<Employee>>  high_earners_by_dep1=  high_earners_by_dep.entrySet().stream()
                     .collect(Collectors.toMap(
                             Map.Entry::getKey,
                             Map.Entry::getValue,
                             (e2,e3) ->e2));

         return  new ResponseEntity(high_earners_by_dep1, HttpStatus.OK);

  //ind median salary (not average)
//👉 Challenge: Sort salaries and pick the middle one
         case "median_salary" :
          List<Double> median_salary = useForRandomTask.stream()
                     .filter(y->y.getSalary()!=null)
                 .map(Employee::getSalary)
                  .sorted()
                  .collect(Collectors.toList());

            int sizes=median_salary.size();
            double middle=0.0;
          //for even
            if(sizes % 2==0 ){
                middle= median_salary.get(sizes/2);
          }else{
                middle = (median_salary.get(sizes / 2 - 1) + median_salary.get(sizes / 2)) / 2;
            }
            return new ResponseEntity("middle  salary is "+middle ,HttpStatus.ACCEPTED);

         case "update_salary" :
Double salarySet=15000.0;
List<Employee> saves=new ArrayList();
       Stream<Employee> saved =useForRandomTask.stream()
                     .filter(r->r.getName() !=null &&
                             (r.getSalary() == null || r.getSalary().doubleValue() == 0.0))
                     .peek(rr->rr.setSalary(salarySet));
       // hit the save end point  api
             for( Employee  s:saved.collect(Collectors.toList()))
             saves.add(s);
          employeeRepo.saveAll(saves);

             return new ResponseEntity("salary has  been update " ,HttpStatus.OK);







//List employees who do not belong to any department (null or empty department)
// Challenge: Handle null/blank departments
//Tag: no_department

         case "no_department" :
                           List<Employee>  no_department= useForRandomTask
                                       .stream()
                                   .filter(t->t.getName()!=null)
                                   .filter(t->t.getDepartment()==null)
                                       .collect(Collectors.toList());
//             If You Want to Return a Custom Message + List:
//             java
//                     Copy
//             Edit
//             Map<String, Object> response = new HashMap<>();
//             response.put("message", "Employees with no department");
//             response.put("data", noDepartment);

           //  return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
             return new ResponseEntity("no_department --->"  +no_department, HttpStatus.NOT_FOUND);

         // Find employees with duplicate names
         case  "duplicate_names" :
           List<Employee> list =new ArrayList();

            Map<String, List<Employee>> duplicate_names=useForRandomTask
                   .stream()
                     .filter(e->e.getName()!=null)
                     .collect(Collectors.groupingBy(
                             Employee::getName,
                             Collectors.toList()));
             List<Map.Entry<String, List<Employee>>> duplicatesName=duplicate_names.entrySet()
                     .stream()
                     .filter(e->e.getValue().size() >1)
                     .collect(Collectors.toList());

             if(!duplicatesName.isEmpty()){
                 return new ResponseEntity("duplicate name" +duplicatesName,HttpStatus.OK);
             }else{
                 return new ResponseEntity("no duplicate name found !" ,HttpStatus.BAD_GATEWAY);

             }


         //4️⃣ List top 3 highest paid employees  // top_3_paid_highest_emp



         case "top_3_paid_highest_emp_old":
             List<Employee> lisOfMax=new ArrayList();
             Double maxPaidEmp=0.0;
           for(Employee employee : useForRandomTask){
               if(employee.getSalary()!=null){
                  lisOfMax.add(employee);
               }
              // lisOfMax.sort(Comparator.comparing(Employee::notifyAll));
               Collections.sort(lisOfMax, new Comparator<Employee>() {
                   @Override
                   public int compare(Employee o1, Employee o2) {
                       return o2.getSalary().compareTo(o1.getSalary());
                   }
               });}
            // get top 3 emp now
           // List<Employee> max3=lisOfMax.size() >3 ? lisOfMax.subList(0,3) :lisOfMax;

             List<Employee> top3 = new ArrayList<>();
             for (int i = 0; i < lisOfMax.size() && i < 3; i++) {
                 top3.add(lisOfMax.get(i));
             }

           //If you want to return only the salaries (not employee details):
//             List<Double> top3Salaries = new ArrayList<>();
//             for (int i = 0; i < Math.min(3, nonNullSalaryEmployees.size()); i++) {
//                 top3Salaries.add(nonNullSalaryEmployees.get(i).getSalary());
//             }
               return new ResponseEntity("max 3 paid .....->emp.. " +top3,HttpStatus.ACCEPTED);




         default:
             //4️⃣ List top 3 highest paid employees  // bydefault
        List<Employee> topHighestPaidEmp=  useForRandomTask.stream()
                     .filter(g->g.getSalary() !=null && g.getName()!=null)
                     .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                     .limit(3)
                     .collect(Collectors.toList());
        return  new ResponseEntity(topHighestPaidEmp ,HttpStatus.ACCEPTED);

     }}

    /**
     * @return
     */
    @Override
    public ResponseEntity<Employee> findSecondMax() {

//        Employee e=new Employee();
//       double salarys= e.getSalary();


        List<Employee> findsecond =employeeRepo .findAll();
        // if lis length is less then 2
        if(findsecond.size() <2){
       return new ResponseEntity("list is empty " ,HttpStatus.BAD_REQUEST);
        }



       // find second higest empy
   Optional<Employee> result=
        findsecond.stream() .filter(d->d.getSalary()!=null)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
   if(result.isPresent()){
       return new ResponseEntity(result.get(),HttpStatus.ACCEPTED);
   }else {
       return new ResponseEntity("list is empty !" ,HttpStatus.BAD_REQUEST);
   }


    }


    public void deleteUserById(Long id) {
        employeeRepo.deleteById(id);
    }

    public boolean exists(Long id) {
        return employeeRepo.existsById(id);
    }


//    @Override
//    public Page<Employee> paginationAndSorting(int page, int size,
//                                               String sortBy, String sortDirection) {
//
//        Sort sort = sortDirection.equalsIgnoreCase("asc")
//                ? Sort.by(sortBy).ascending()
//                : Sort.by(sortBy).descending();  // both ascending order or descending
//        PageRequest pageRequest = PageRequest.of(page, size, sort);
//
//        if (sortBy != null && !sortBy.isEmpty()) {
//            Employee ep= employeeRepo.findByNameContainingIgnoreCase(sort, pageRequest);
//        } else {
//            return employeeRepo.findAll(pageRequest);
//        }
//        return null;
//    }
//
//
//
//








}