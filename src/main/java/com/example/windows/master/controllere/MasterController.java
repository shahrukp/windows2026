package com.example.windows.master.controllere;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/api")
// localhost://8080/api/methodname
public class MasterController {

    @Autowired
    @Lazy
    private  JavaAllinCodedemo javaAllinCodedemo;
//    @Autowired
//    private PathVariableVsRequestParam pathVariableVsRequestParam;
    @GetMapping("/{methodName}")
    //public ResponseEntity<String> invokedMethod(@PathVariable String methodName){
    public ResponseEntity<?> invokedMethod(@PathVariable String methodName){
        Method method = null;
        try{
            method=javaAllinCodedemo.getClass().getDeclaredMethod(methodName);
          Object result= method.invoke(javaAllinCodedemo);
          if(result instanceof ResponseEntity){
              return (ResponseEntity<?>)result;
          }
          // return  new ResponseEntity((HttpStatusCode) method.invoke(javaAllinCodedemo, HttpStatus.ACCEPTED));
              return ResponseEntity.ok(result);
        }catch (NoSuchMethodException e) {
            return new ResponseEntity("invalid method , no method found", HttpStatus.BAD_GATEWAY);
        }catch (Exception e){
            return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error while invoking " +e.getMessage());
        }
    }



}
