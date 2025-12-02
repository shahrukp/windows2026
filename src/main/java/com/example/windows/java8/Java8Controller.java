package com.example.windows.java8;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/java/8/")
public class Java8Controller {

    @GetMapping
    public String  callLambda(){
        LambdaExperssion le=new LambdaExperssion();
return le.displayResult();

    }

    @GetMapping("/max")
    public List<Integer> maxduplicity(){
        LambdaExperssion le=new LambdaExperssion();

        return le.arrrayList();

    }
}
