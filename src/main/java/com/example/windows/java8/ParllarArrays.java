package com.example.windows.java8;

import org.hibernate.internal.util.compare.ComparableComparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;
import java.lang.reflect.Array;
import java.util.*;


@RequestMapping("/api/parllar/")
@RestController
public class ParllarArrays {

   // http://localhost:8081/api/parllar/par
    @GetMapping("par")
    public  void  sortArr(){
        List<Integer> numbers = Arrays.asList(3,66,5,3,52,1,0,2,8,10);
        // sort the arr asecnidng and descending order
       // Arrays.sort(numbers,Comparable.class); use for old
        Collections.sort(numbers);
       // Collections.sort(Comparator.comparingDouble(a,v)->va);
numbers.stream()
        .forEach(e->System.out.println(e));

    }


}
