package com.example.windows.microservices;


import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/use/for/microserives")
public class UserControllerMicroservies {


    // Url http://localhost:8080/use/for/microserives/77 working fine here itslef
   // output is -> "name":"shahruk ","email":"@shahruk","id":99}
    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id){
        //return new UserDto("shahruk" , "briyani" ,id);
        UserDto userDto =new UserDto("shahruk ", "@shahruk", id); // why cant return
        return  new ResponseEntity(userDto, HttpStatus.ACCEPTED);
    }
}
