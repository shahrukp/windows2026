package com.example.windows.microservices;


import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/webclient/")
@RestController
public class WebClientCallingVia {

    // call the contrillerMicroservies via web client

    // create/define instcen of webclient
    // need to add depencady here
      //dependncies name -> webflux FIRst add <<---
   /*WebClient webClient= WebClient.create(); here also we can put the belwow url


    public Mono<String> getOrder(@PathVariable long userId){

        return  webClient.get()
                .url("http://localhost:8080/use/for/microserives/77");
        .retrieve()
                .bodytoMono(UserDto.class)
                .map(e->"order palce " +e.name);


    }*/


}
