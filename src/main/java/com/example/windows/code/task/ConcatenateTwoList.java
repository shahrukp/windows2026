package com.example.windows.code.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenateTwoList {


    public String concatenate(){

        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

       Stream <String> ressult= Stream.concat(list1.stream(), list2.stream());
        return "ressult" +ressult.collect(Collectors.toList());
    }
}
