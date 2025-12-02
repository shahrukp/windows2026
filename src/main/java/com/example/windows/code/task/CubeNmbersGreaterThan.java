package com.example.windows.code.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeNmbersGreaterThan {

    // cude numbers greater than 50
    public String cude(){

        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);


     List<Integer>  outptus=  integerList.stream()
             .filter(e->e!=null)
            // . Method reference ke through (Math.pow)
             .map(n -> (int) Math.pow(n, 3))
             .filter(e-> e>50)
             .collect(Collectors.toList());

        return "output is for > then number s " +outptus;

    }


}
