package com.example.windows.springboot.annotation;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//@Component
@RequestMapping("/apis/")
@RestController
public class PathVariableVsRequestParam {

// call the belwo all method in master controller wip
    // endpoint url http://localhost:8080/apis/pathvarible/iphone for single code
   // @GetMapping("pathvarible/{productcode}") for single product code
@GetMapping("get/all/{productCode}/{productPrice}") // for multiple product code
//endpoint -> http://localhost:8080/apis/get/all/rrr/one for single multiple
    public String pathVarible( @PathVariable String productCode ,
                               @PathVariable String productPrice){
     return productCode  +"is your product code please do not share with anyone " +
             "and price is !" +productPrice;
    }

    // requestparama annotaion
    // url ?? -> http://localhost:8080/apis/pathvarible?productcode=INFTHR for single
    @GetMapping("pathvarible")
    public String requestParam( @RequestParam String productcode){
        return productcode  +"is your product code please do not share with anyone !";

    }

    // requestparama annotaion
    // url ?? -> http://localhost:8080/apis/pathvarible?productcode=INFTHR&countyCode=91 for multiple
    @GetMapping("pathvarible/multiples")
    public String requestParamForMultilple( @RequestParam String productcode ,
                                            @RequestParam int  countyCode){
        return productcode  +"is your product code please do not share with anyone !"
                +countyCode +" is your countyr code ";

    }


}
