package com.example.windows.code.task;

import java.util.*;

public class FindMissingnumberInArray {



    public String findMissingNumbe(){
// find multiple missing numner
    List<Integer> numbers=Arrays.asList(1,2,4,50,57,20,53);

        int n = numbers.size() + 1; // total elements including the missing one
        int expectedSum = n * (n + 1) / 2;


        int actualSum = 0;
        for (int num : numbers) {
            actualSum += num;

        }

        int missing = expectedSum - actualSum;
        return "Missing  multiple number : " + missing;

    }
    public String findMultipleMissingNumber(){
        List<Integer> numbers=Arrays.asList(1,2,4,50,57,20,53);

        List<Integer> missing = new ArrayList<>();

       int min=Collections.min(numbers);
       int max=Collections.min(numbers);


       for(int i=min; i<=max;i++){
           if(!numbers.contains(i)){
               System.out.println("Miisng Numbers are" +numbers.get(i));
               missing.add(i);
           }

       }
       System.out.println("missing number are " +missing);

        return "missing numnbr are " +missing;
    }

}
