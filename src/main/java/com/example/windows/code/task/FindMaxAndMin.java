package com.example.windows.code.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMaxAndMin {


    public  String findMaxMin(){

        List<Integer> list= Arrays.asList(12,4,5,6,-2,78,9);//min -2, max=78

        // min
        int min =0;
        for(int i=0; i<list.size();i++){
            // if(list.get(i) <min){ // for min
            if(list.get(i) >min){ // for max
                min=list.get(i);
            }

        }

        return "the min value  is " +min;
    }


   // find max and min via stream

    public String findMaxMinstreamAPI(){
        List<Integer> list= Arrays.asList(12,4,5,6,-2,78,9);//min -2, max=78
    //int r= IntStream.of(list) // ❌ Problem: IntStream.of(...) expects int[], not List<Integer>
         int max=list.stream()
                    .max(Comparator.comparingInt(Integer::intValue))
                    .orElse(0);

        return "output is " +max;
    }


}
