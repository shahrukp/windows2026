package com.example.windows.springboot.annotation_2026;

import org.springframework.stereotype.Component;

@Component
public class ComponentAnnotaion {

    public boolean isAmountValid(double amount){
        return amount >0; // return if anmount is grterthen 0
    }
}
