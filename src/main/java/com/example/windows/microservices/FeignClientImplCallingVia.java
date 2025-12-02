package com.example.windows.microservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feignclient/")
public class FeignClientImplCallingVia {

    @Autowired(required=true)
    @Lazy
    private FeignClientCallingVia feignClientCallingVia;


    @GetMapping("feignclient/{id}")
    public String placeOrder(@PathVariable Long id){
        // inject the feignclient interface

      UserDto userDto=  feignClientCallingVia.getOrderSerivces(id);

      return  "order placed "+userDto.id();
    }
}
