package com.example.windows.microservices;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/")
public class RestTemplateCallingVia {

    RestTemplate restTemplate=new RestTemplate();

    // url http://localhost:8080/order/rest/99
    //output is -> order placed : user name {"name":"shahruk ","email":"@shahruk","id":99}

@GetMapping("rest/{useId}")
    public  String callViarestTemplate(@PathVariable Long useId){
        String url="http://localhost:8080/use/for/microserives/"+useId; // from UserControllerMicroserives class
    UserDto user=restTemplate.getForObject(url,UserDto.class);
    // track the actaul json response
   String json = restTemplate.getForObject(url, String.class);
   System.out.print("json response" +json);
        return "order placed  : user name " +json;
    }


}
