package com.example.windows.code.task;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortValues {


    public String sortValues(){ // ascending and desending order

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
         // ascending order and desending order

      List<Integer> res= myList.stream()
               // .sorted(Comparator.naturalOrder()) //ascending order
              .sorted(Comparator.reverseOrder()) // revser the order
                .collect(Collectors.toList());

        return "outptu is" +res;
    }
}
