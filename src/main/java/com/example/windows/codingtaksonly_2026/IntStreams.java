package com.example.windows.codingtaksonly_2026;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class IntStreams {
    public String intStreamOpeartion(){
      IntStream ints=IntStream.of(1,2,33,3,45,67,89,87);
      IntStream.rangeClosed(0,10).
           forEach(e->System.out.println("one to ten "+e));
         int i=1;
      Stream te= Stream.generate(()-> i<=10);
        return "one_to_ten"  +te;
    }}
