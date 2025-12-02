package com.example.windows.code.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondSmallestNumber {



    public String secondSmallestNumber(){

        int []num={10,5,8,20,5,3,10}; // second samllest number ;  5

        Arrays.sort(num);  // [0, 3, 5, 5, 8, 10]

        int smallest = num[0]; // 0
        int secondSmallest = -1;

        for(int i=1; i<num.length; i++){
            if(num[i] != smallest){
                secondSmallest = num[i];
                break;
            }
        }
        System.out.println("Second Smallest: " + secondSmallest);


     Integer s= Arrays.stream(num)
                .boxed()
              //  .sorted(Comparator.reverseOrder()) // 20, 10, 10, 8 5, 5, 3 // descending order
             .sorted() // ascending order  // 3,5,5,8,10,10,20
           //  .sorted(Comparator.naturalOrder()) // ascending order
                 .distinct()  // 3,5,8,10,20
                .skip(1)
                .findFirst()
             .orElse(0);
// old approch






        return "second smallest number " +s;
    }
}
