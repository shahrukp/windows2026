package com.example.windows.codingtaksonly_2026;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// both are intermediate operations
@Component
public class MapVsFllatMap {



    //map
    public String mapIndermeditate(){
    List<String>  records=Arrays.asList("shahruk","faruk","tilubabu","tilubabuni", "tom", "jerry");
        //make first char toupper case

   List<String> output=records.stream()
                .map(e->Character.toUpperCase(e.charAt(0))+e.substring(1))
           .map(String::valueOf)
                .collect(Collectors.toList());

        return  "work ? -> "+output;
    }
    // flatmap
    public String flatMap(){
        List<String> l=Arrays.asList("tomy","jerry","deadpol");
        List<String> l1=Arrays.asList("shahruk","j","pol");
        List<Integer> lage=Arrays.asList(12,45,9);

     List<?> fm= Stream.of(l,l1,lage)
                .flatMap(e->e.stream())
                .collect(Collectors.toList());

        return "flatmap output is -> " +fm;
    }



}
