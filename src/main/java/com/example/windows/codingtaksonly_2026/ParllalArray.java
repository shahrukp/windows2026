package com.example.windows.codingtaksonly_2026;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ParllalArray {

    public String parllarArray(){
       List<Integer> list= Arrays.asList(1,2,32,4,567,89,8);

       //sort
       Stream<Integer> parllar =list.parallelStream();
        return  "parllal thread safe-> " +parllar.collect(Collectors.toList());
    }
}
