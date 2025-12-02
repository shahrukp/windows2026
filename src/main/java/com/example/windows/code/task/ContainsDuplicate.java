package com.example.windows.code.task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContainsDuplicate {



    public String containsDuplicate(){


        List<Integer> myList = Arrays.asList(1,22,4,5,99) ; // return true if duplicate foudn


      myList.stream()
                .map(e->e + " ") // convert into stirng
                .collect(Collectors.groupingBy(
                        fr->fr,
                        Collectors.counting()))
              .entrySet()
              .stream()
             // .filter(e->e>1)
              .forEach(e->System.out.println(true));





        return null;
    }
}
