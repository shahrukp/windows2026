package com.example.windows.codingtaksonly;

import jakarta.el.MethodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@RequestMapping("/coding/task/")
@RestController
public class MasterControllerCallCodingTaks {

// master endpoint
   // localhost:8080/coding/task/methodname
    @Autowired
    private  CodingTaksOnly codingTaksOnly;

    @GetMapping("/{methodName}")
    //public ResponseEntity<String> invokedMethod(@PathVariable String methodName){
    public String invokedMethod(@PathVariable String methodName){
        try{
            Method method=codingTaksOnly.getClass().getDeclaredMethod(methodName);
            // return  new ResponseEntity((HttpStatusCode) method.invoke(javaAllinCodedemo, HttpStatus.ACCEPTED));
            return (String) method.invoke(codingTaksOnly);
        }catch (Exception e){
          //  return  new ResponseEntity<>( "invalid method ", HttpStatus.BAD_GATEWAY);
          // return  "invalid file name";
        }
        return  "method called !";


    }
}
