package com.example.windows.java8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api/supplier/")
public class SupplierInterfaces {

    // it has one method get
    // presnt in java function package
    // functional interface
    // cant take parameters however produce the reuslt

   // http://localhost:8081/api/supplier/
    @GetMapping
    public String supplierExamples(){
    Supplier<String> s=new Supplier<String>() {
        @Override
        public String get() {
            return "hye im part of supplier ";
        }
    };
System.out.println("get " +s.get());
    // other ways

    Supplier<String> suppliers = () ->"hye im part of supplier ";
     String re=suppliers.get();
    System.out.println(re);

    return null;
}}
