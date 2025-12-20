package com.example.windows.codingtaksonly_2026;


import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoveZeroToLeftSideRight {


    public String moveZeroLeft() {

        List<Integer> number = Arrays.asList(1, 0, 5, 0, 4, 0, 20, 3, 0, 4); //output  0,0,0,0,1,5,4,20,3,4,//duplicate ?
        int arr[]={1,0,5,0,4,0,20,3,0,4};
       // List<List<Integer>> list = new ArrayList<>();
       // number.stream()
               // .mapToDouble(Integer::intValue)
   List<Integer> finalOutput=Arrays.stream(arr)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.partitioningBy
                                (e1 -> e1 == 0), // thats it 2rd one automatically done
                        objRef -> {
//                            List<Double> zero = objRef.get(true); // zero
//                            List<Double> nonZero = objRef.get(false); // nonZero

                            List<Integer> zero = objRef.get(true); // zero
                            List<Integer> nonZero = objRef.get(false); // nonZero
                            zero.addAll(nonZero);
                            return zero;
                        }));
        return "moved zero ? -> " +finalOutput;
    }

}
