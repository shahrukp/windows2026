package com.example.windows.java8;

/*So, anonymous classes are not limited to functional interface methods.
        They can also access:
        Abstract methods (must implement)
        Default methods (via super)
        Static methods (via interface name)*/

import org.aspectj.weaver.ast.Call;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

interface Functional{
    public String sayMessage();
}

@RestController
@RequestMapping("/api/annymous/")
// localhost://api/api/annymous/annymous
public class AnnymousClasss {
        // using annymous class
    @GetMapping("anno")
    public String classMethod(){
        Functional f = new Functional() {
            @Override
            public String sayMessage() {
                return "hi im calling from the annymous class that doest have name !";
            }
        };
      return  f.sayMessage();
    }

    // call predifine methods
  //  http://localhost:8081/api/annymous/callable
    @GetMapping("callable")
    public Callable callAbles(){
// this is functional interfaace with annymous mehtod
        Callable c=new Callable() {
            @Override
            public Object call() throws Exception {
                return "calling callable via annymous class !";
            }
        };
// Runable
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running from anonymous class!");
            }
        };
        return c;
    }
}
