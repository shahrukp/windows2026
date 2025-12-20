package com.example.windows.interview_task_2026;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/even/odd/")
public class PrimeorOddEvenNumber {


    // http://localhost:8084/even/odd/check
    @GetMapping("check")
    public String evenOdd(){

        int number=12; // Number jo2 se divide ho jaye even , number % 2 even odd
        // if number divide by 2 then even
        if(number % 2==0){
            return "Even Number " +number;
        }else
            return "odd Number " + number;

    }


    // prime number
    @GetMapping("prime")
    public String prime(){

        int isPrimeNumber =13;  // jo 1 ya khud se divide ho note 1 is not prime number
        if(isPrimeNumber <2){
            return  "not prime number ";
        }


        for(int i=2; i<isPrimeNumber;i++) {
            if (isPrimeNumber % 2 == 0) {
                return "not prime number" + isPrimeNumber;
            } else {
                return "prime number " + isPrimeNumber;
            }
        }
        return null;
    }

}
