package com.example.windows.collection2026;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compiler/runtime/error/")
public class CommpilerVsRunTimeError {



    @GetMapping("/compilertime")
    public String compilerTimeError(){

      //  int a="shahruk"; //compiler time error due to time mismatch

        return  null;
    }

    @GetMapping("/rumtime")
    public String runTimeError(){

          int x=10/0; //run time error due to ArithmeticException at runtime

        return  null;
    }


}
