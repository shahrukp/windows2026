package com.example.windows.code.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStartingWithOne {
    public String numberStartingWithOne() {

        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 1); // convert into string
        for (int xx : myList) {
            String x1 = Integer.toString(xx);
            List<String> one = new ArrayList<>();

            List<String> reesult = myList.stream()
                    .map(e -> e + " ") // convert into string
                    .filter(e -> e.startsWith("1"))
                    .collect(Collectors.toList());

            System.out.println("starting with 1" + reesult);

            List<Integer> x = new ArrayList<>();
            myList.stream()
                    .filter(e -> e != null) // list is not empty
                    .collect(Collectors.collectingAndThen(
                            Collectors.partitioningBy(finisher -> finisher == 1),
                            e -> {
                                List<Integer> withZero = e.get(true);
                                List<Integer> zero = e.get(false);
                                return x.addAll(withZero);
                            }));
            return "output is genrated !";
        }
    return  "output is genrateted! " ; }
    }
