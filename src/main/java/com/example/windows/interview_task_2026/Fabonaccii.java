package com.example.windows.interview_task_2026;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fabonacci/")
@RestController
public class Fabonaccii {


    // http://localhost:8084/fabonacci/fab/
@GetMapping("/fab")
    public  int fabonacci(){
       int n=10;
       int first=1;
       int second =0;
       int reuslt=0;

  for(int i=0;i<n-1; i++){

      second=first;
      first=second;
      reuslt=first;
      System.out.println(reuslt);
    }
    return reuslt;

}
}
