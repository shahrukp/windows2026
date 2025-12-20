package com.example.windows.codingtaksonly_2026;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OptonalClass {

    public String optionalFinalWarpper(){
        String str="java developer";
    Boolean st=  Optional.of(str)
                .isPresent();
        return  " true or false  -> " +st;

    }
}
