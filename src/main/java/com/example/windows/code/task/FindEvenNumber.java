package com.example.windows.code.task;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindEvenNumber {

    public String EvenNumber(){
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        // find only even number using stream api
      List<Integer>evenNumbers=list.stream()
               .filter(e->e!=null)
               .filter(e->e%2==0 )  // only even numer %2==0
               .collect(Collectors.toList());

        return "even numbers only " +evenNumbers;
    }
}
