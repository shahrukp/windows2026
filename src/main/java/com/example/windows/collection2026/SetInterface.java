package com.example.windows.collection2026;


import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SetInterface {




    public String   list(){

        Set<Integer> numbers =new HashSet<>();
        numbers.add(1);
        numbers.add(1); // duplicate not allowed
        numbers.add(null); // only one null is allowed
        numbers.add(null); // only one null is allowed 2?
        numbers.add(2); // only one null is allowed
        numbers.add(5); // only one null is allowed
        numbers.add(6); // only one null is allowed
                      // not maintiane insertion order
        numbers.add(0);
        return  "outptu is  -> "+ numbers.toString() ;
    }
}
