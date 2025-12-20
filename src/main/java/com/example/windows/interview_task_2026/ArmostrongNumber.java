package com.example.windows.interview_task_2026;

import jdk.jfr.DataAmount;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v2/")
@RestController
public class ArmostrongNumber {

  // http://localhost:8084/v2/armostrong
    @GetMapping("armostrong")
    public int armostrongNumber(){

        int armostrong=159;
        System.out.println("origianl   -> " +armostrong);
int original=armostrong;
     int len=String.valueOf(armostrong).length();
     System.out.println("output is 3 -> " +len);
     int result=0;
        while(armostrong !=0){
            //get the last digit
           int lastDigit= armostrong%10;
           System.out.println("lastDigit " +lastDigit);
         result+=Math.pow(lastDigit,len);
       //   armostrong/=10;
            armostrong = armostrong / 10;
        }System.out.println("after reverse   -> " +result);
        return (result==original) ? 1:-1; //1 for yes and -1 for no
    }
}
