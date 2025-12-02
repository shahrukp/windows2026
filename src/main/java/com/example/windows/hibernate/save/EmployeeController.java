package com.example.windows.hibernate.save;


import com.example.windows.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


// functional interface

interface functionInterfaces{
    // abstrct method
    int addvalue(int a, int b);

    default  int addDeatils(){
        return 0;
    }
    default   int addDeatilsOne(){
        return 0;
    }
    default int addDeatilsTwo(int b){
        return 0;
    }

    static  int doMulti(int a, int b){
        return a*b;
    }


}

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    // check endpoints apis
    @GetMapping()
    public String message() {
        return "ye Allah is mahine ke kahtm  hone se pahle job laga dena aur bg bhi sab thik ho jana ";
    }

    @Autowired
    @Lazy
    private final EmployeDao employeDao;

    public EmployeeController(EmployeDao employeDao) {
        System.out.println("save hibernate object via presist method ");
        this.employeDao = employeDao;
    }

    // url localhost//8081/api/employee/persist
    // save hibernate object
    @PostMapping("/persist")
    public void saveObject(@RequestBody Employee emp) {
        System.out.println("save hibernate object via presist method ");
        employeDao.saveStudent(emp);
    }

    // lamda  expression
    @GetMapping("/add")
    public String lambdaExperssion() {

        functionInterfaces ref = (int a, int b) -> {
            return a + b;

        };
        System.out.println(ref.addvalue(12, 20)); // 32

        return "output is " + ref.addvalue(12, 41);

    }

    @GetMapping("/annymousfunction")
    public String annymousFunction() {
// annoymous functions
        functionInterfaces f = new functionInterfaces() {
            @Override
            public int addvalue(int a, int b) {
                return a+b;
            }
        };

        // call remaning methods default and static
        // call static mehtod because always belogs to class or interface
      int x= functionInterfaces.doMulti(12,7);
      System.out.println("calling static method via interface name " +x);
      //default method calling via lambda or annymous functions
       int xx= f.addDeatils();
       System.out.println("pincode " +xx);
        return  "annymous functions" +f.addvalue(30,70);

    }




}