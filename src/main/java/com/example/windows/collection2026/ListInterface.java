package com.example.windows.collection2026;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ListInterface {


    public String listInterface(){
        List<Integer> numbers =new ArrayList<>();
        numbers.add(1);
        numbers.add(1); // duplicate  allowed
        numbers.add(null); //  null is allowed
        numbers.add(null); //  null is allowed 2? Yes multiples
        numbers.add(2);
        numbers.add(5);
        numbers.add(6); // only one null is allowed
        //  maintiane insertion order

        return  "list inteface -> " +numbers.toString();
    }
}
