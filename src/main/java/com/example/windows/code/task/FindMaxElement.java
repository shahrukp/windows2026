package com.example.windows.code.task;

import java.awt.desktop.OpenFilesEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindMaxElement {

    public  String findMaxValue(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        // find max

   Integer max= myList.stream()
                .filter(e->e!=null)
                .max(Integer::compare)
                  .get();
        System.out.println(max);

       return "output " +max;
    }
}
