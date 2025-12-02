package com.example.windows.code.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class flatMap {



    public String  flatMap(){

        List<String> list1 = Arrays.asList("Java", "Spring");
        List<String> list2 = Arrays.asList("Angular", "React");
        

      List<String>  falttern=Stream.of(list1, list2)
                .flatMap(e->e.stream()) // convert the result into flattern
                .collect(Collectors.toList());

        return "falttern => " +falttern;
    }
}
