package com.example.windows.microservices;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClien(url ="user-service",
      //  name="http://localhost:8080/use/for/microserives/77")

public interface FeignClientCallingVia {

    @GetMapping("/feignclient/{userId}")
     UserDto getOrderSerivces(@PathVariable Long userId);
}
