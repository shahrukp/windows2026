package com.example.windows.codingtaksonly_2026;


import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class SupplierInterface {
        public String supplierInterfaces(){
            String str="shahruk";
        int  num=100;
        Supplier<Integer> s=new Supplier<Integer>() {  // 1st
            @Override
            public Integer get() {
                  if(str.contains("m"))
                  {return  101;
                  }else{
                return num;
            }}};
        Supplier<String> objRef =() -> "  rs_only"; // 2rd
        return "number is -> " + s.get() +objRef.get();
    }
}
