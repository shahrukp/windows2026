package com.example.windows.code.task;

import java.util.Arrays;
import java.util.List;

public class FindTheTotalNumberOfElements {



    public String findTheTotalNumberOfElements(){
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

     long x= myList.stream()
                .filter(e->e!=null)
                .count();


        return "total number is " +x;
    }

}
