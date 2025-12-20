package com.example.windows.springboot.annotation_2026;

import org.springframework.web.bind.annotation.*;

//@Component
@RequestMapping("/apis/")
@RestController
public class PathVariableVsRequestParam {

// call the belwo all method in master controller wip
    // endpoint url http://localhost:8084/apis/pathvarible/iphone for single code
   // @GetMapping("pathvarible/{productcode}") for single product code
// original url -> http://localhost:8084/apis/get/allT/TXT/
    @GetMapping("get/all/{productCode" + "}/{productPrice}") // for multiple product code
//endpoint -> http://localhost:8084/apis/get/all/rrr/onelack for single multiple
    public String pathVarible( @PathVariable String productCode ,
                               @PathVariable String productPrice){
     return productCode  +"is your product code please do not share with anyone " +
             "and price is... !" +productPrice;}

    // requestparama annotaion
    // url ?? -> http://localhost:8084/apis/requestparam?productcode=INFTHR for single
    @GetMapping("requestparam")
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
