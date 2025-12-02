package com.example.windows.interceptores;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RestController
public class MyController {
    @GetMapping("welocme")
    public String welcome(){
        return  "welcome";
    }
    @GetMapping("fetch")
    public String showrecords(){
        return  "records";
    }
}
