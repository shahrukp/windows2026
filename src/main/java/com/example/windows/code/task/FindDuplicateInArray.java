package com.example.windows.code.task;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateInArray {



    public String findDuplicate(){
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);


        Set<Integer> list =new HashSet<>(); // not allowe duplicated
 myList.stream()
               .filter(e->e!=null) // if not null
               .filter(e-> !list.add(e)) // if not
               .forEach(e->System.out.println(e));

        return  "dduplicate values send !";
    }
}