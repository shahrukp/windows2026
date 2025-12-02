package com.example.windows.code.task;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeated {



    public String firstNonRepeatedChar(){
        String input = "Java articles are Awesome"; // count first non repating char
  Optional<Character> output= input.chars()

                .mapToObj(e->(char)e)
                .collect(Collectors.groupingBy(
                        fr->fr,
                        LinkedHashMap::new, // mainttain the order
                        Collectors.counting())).

      entrySet()
                .stream()
//                .filter(entry->entry.getValue()>1) // for first repating char
           .filter(entry->entry.getValue()>=1) // for  non first repating char
                .map(Map.Entry::getKey)
                .findFirst();



        return "output is " +output;  // j




    }
}
