package com.example.windows.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

@RequestMapping("/stream/api/")
@RestController

public class StreamAPI {


    // revesers the string
    @GetMapping("reveser")
    public String reveserString(){
        String name="CBA";
      String result=  name.chars()
                .mapToObj(c-> (char) c)
                .map(String::valueOf)
                .reduce("", (a,b) -> b+a);
        return "output  " +result;

    }
    // count each occurence given string and list
    public String EachOccurence(){

        String str="abcdrfabcd";
      Map<String ,Long> maps=  Arrays
                       .stream(str.replaceAll("\\s+", "").split(""))
                         .collect(Collectors.
                        groupingBy(f->f ,
                        Collectors.counting()));
               maps.forEach((key, value) ->System.out.println("char" +key +" ocurnece" +value));
        return null;

    }

    public String EachOccurenceList(){
        List<String>  lists= Arrays.asList("AA" ,"BB", "CC", "AA" ,"DD" ,"BB");

    Map<String, Long> result=  lists.stream()
            .collect(Collectors.groupingBy(a -> a,Collectors.counting()));
            result.forEach((key1, value1) ->System.out.println("char"  + key1 +" occurence time" +value1));

return null;


    }


    // find first non reapting char

    public static String toupperCase(){


        String str="aabbffdddkk"; // UpperCase output r
      String toUcase= str.chars()
              .mapToObj(c->String.valueOf((char) c)
              .toUpperCase())
               .collect(Collectors.joining());

        return toUcase;

    }
    public static String firstNonRepatingChar(){


        String str="aabbffrdddokk"; //  r non repeaing cahr
       Optional<Character>  chr=  str.chars()
                         .mapToObj(c->(char) c)
                         .collect(Collectors.groupingBy(
                         Function.identity(),
                         LinkedHashMap::new, Collectors.counting()))
                         .entrySet()
                         .stream()
                         .filter(entry ->entry.getValue()==1)
                         .map(Map.Entry::getKey)
               .skip(1)
                         .findFirst();


       if(chr.isPresent()){
           System.out.println("output " +chr.get());
       }else{

           System.out.println("No Non-repeating  char found !");
       }

        return null;

    }
    @GetMapping("message")
    public String welcomeMessage(){

        return "Hi Welcome !";
    }
}
