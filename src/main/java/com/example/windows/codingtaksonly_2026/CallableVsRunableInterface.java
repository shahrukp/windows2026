package com.example.windows.codingtaksonly_2026;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Component
public class CallableVsRunableInterface {
    // java lang packge

    public  String runableExample(){

      List<Integer>list= Arrays.asList(12,3,4,5,67,8,76); // ascending order
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
     List<Integer>   sortedByAscending=list.stream()
                     .sorted(Comparator.reverseOrder())
                     .collect(Collectors.toList());

     System.out.println("sortedByAscending" +sortedByAscending);

            }
        };
        // call above method
        runnable.run();

        return  "callable has  bend sent to console!" ;
    }

    // java util packge
    public  String callableExample() throws Exception {
        List<Integer>list= Arrays.asList(12,3,4,5,67,8,76); // ascending order

        Callable <Optional<Integer>> callable=new Callable<Optional<Integer>>() {
            @Override
            public Optional<Integer> call() throws Exception {

                    Optional<Integer> sortedByAscendingDesecnding=list.stream()

                            .sorted(Comparator.reverseOrder())
                            .skip(1)
                            .findFirst();
                           // .collect(Collectors.toList());
                System.out.println("callable...." );

                return sortedByAscendingDesecnding;
            }
        };

        // second highest number


        return  " -> " +callable.call() ;
    }
}
