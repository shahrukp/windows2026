package com.example.windows.interview_task_2026;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class Palindrom {
   // http://localhost:8084/v1/palindrom
    @GetMapping("palindrom")
    public String chekcPalindrom(){
String str="asA"; //what is palindrom -> read valuea backword and forward same asa->asa , asb ->bsa <-not
        System.out.println("original " +str);
    String result=str.chars()
                .mapToObj(c->(char)+c)
                .map(String::valueOf)
                .reduce("",(a,b)->b+a);
    System.out.println("result " +result);
    // chekc both
    boolean x= str.equalsIgnoreCase(result) ? true :false;
        return "true/false ? ---- -> " +x;
    }
}
