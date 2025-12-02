package com.example.windows.code.task;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VirtushaTask {

    public  static int  processMultiTask(List<Integer> number){
        // print odd number
      List oddNumber= number.stream()
                .filter(e-> e%2!=0)
                        .collect(Collectors.toList());
      System.out.println("odd number are " +oddNumber);
        // remeaning  do squre for even
        List squreTheNumber= number.stream()
                .filter(num->num %2 ==0)
                .map(n->n*n)
                .collect(Collectors.toList());
        System.out.println("squreTheNumber numbers " +squreTheNumber);

        // print desecending order
        List descendingOrder= number.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("decending order" +descendingOrder);
        // get top 5 elementns
        List top5Elemeents= number.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("top5Elemeents are " +top5Elemeents);



System.out.println("runnung the methods ");

     return 0;
    }
    public  static void  main (String args[]){

      List<Integer> numbers= Arrays.asList(1,23,4,0,5,6,7,8,76,54,3,5);

        processMultiTask(numbers);
    }




}
