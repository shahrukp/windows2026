package com.example.windows.springboot.annotation_2026;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/path/request/")
@RestController
public class PathVariablesVsRequestParam2026 {

    // http://localhost:8084/path/request/p/Xhome/29
    @GetMapping("/p/{code}/{age}")
    public  String athaVariable(@PathVariable String code,@PathVariable int age){
        return "code   is  -> "+code  +"and limit" +age;
    }
    // http://localhost:8084/r/?codeX=Xhomie&price=32
    @GetMapping("/r") //?
    public  String requestParam(@RequestParam(required = false) String  codeX , @RequestParam int price ){
        return "codeX is..  -> " +codeX +"and price is " +price;
    }}
