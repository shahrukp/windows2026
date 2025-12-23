package com.example.windows.corejava_2026;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/method/")
@RestController
public class Methods {



    //http://localhost:8084/v1/method/methods
    @GetMapping("methods")
    public static int  methodTypes(){
        String str="shahruk_kahn";
        // predefine method
      int x= str.length();
      //  System.out.println("predefine method" +x)  ;
        //  user define method
        System.out.println("1 to 10 " +userDefineMethood.mehtodX()); // static method
        return  +userDefineMethood.mehtodX() +x;
    }
}
