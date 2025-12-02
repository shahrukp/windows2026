package com.example.windows.java8;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daimond/problms/")
public class CallAAandBController {
//    @Autowired
//    AAandBImpl implmentsAAandBInterafce;

    public String daimondProblms(){
        System.out.println("aa and b interface method called");
      return  null;
    }
}
