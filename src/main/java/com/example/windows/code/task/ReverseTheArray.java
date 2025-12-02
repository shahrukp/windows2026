package com.example.windows.code.task;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseTheArray {

    public String reverseArray() {

        int arr[] = {1, 2, 3, 5, 6, 8, 76, 9, 3}; // 3 9, 76, ....2,1
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + ",");
        }
        // using stream api
//    List<Integer> reverseOrder= (List<Integer>) Arrays.stream(arr)
//            .collect(Collectors.collectingAndThen(
//                    Collectors.toList(),list->{
//                        Collections.reverse(list);
//                                return list;
//        }));
//        return  reverseOrder.stream()
//                .map(String ::valueOf)
//                .collect(Collectors.joining(" ,"));
//
//        return "null" +reverseOrder.collect(Collectors.toList());

        return null;
    }
}

