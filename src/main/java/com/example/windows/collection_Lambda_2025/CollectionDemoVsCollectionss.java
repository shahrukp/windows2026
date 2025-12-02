package com.example.windows.collection_Lambda_2025;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;



@Component
public class CollectionDemoVsCollectionss {

    public String collectionVscollections(){
      //  List<?> — Wildcard (Unknown Type
       // The list can hold elements of some unknown type, 
    List<?> collections= Arrays.asList("shahruk" ,"pathan" ,33l, 99.0, "khan_Shahruk." ,99 ,"Sonubabu");
       // List<?> collections= Arrays.asList("Tilu" ,"pathan" ,32l, 89.0, "sk" ,9 ,"Babu");
        System.out.println(":  inside  collection  method ");
//            ❌ Two issues here:
//  Read only
//            List<?> means an unknown type list — you can’t modify it (add or remove elements).
//                    Java prevents this for type safety.
//
//            So collections.remove("pathan") is not allowed on a List<?>.
//
//            Even if it were allowed, you can’t modify (remove) a list while iterating with a for-each loop — it will throw a
//👉 java.util.ConcurrentModificationException.
//            List<?> = a list of unknown element type.
//            You can only read elements, not modify them.
      //   collections.remove("pathan"); // ❌ Problem here
            // solution for the above problem

            List<Object> printRecord = new ArrayList<>(collections); // copy to modifiable list

            printRecord.remove("pathan");
         return "generic type data ? " +printRecord; // after remove pathan
    }

    public String revserTheString(){
        String  number="6202";
String result =number.chars()
        .mapToObj(chr->(char)chr) // convert into char
        .map(String::valueOf) //  now convert back into string
        .reduce("",(a,b)->b+a);
        return "revser the string welcome to ->  " +
                " -> " +result;
    }
// revser the stirng
    public String checkOccurence(){
      List<String> myList=Arrays.asList("aa","bb" ,"aa" ,"FF", "eE", "AA" ,"bb" ,"cc", "dd" ,"ee");

     Map<Object, Long> map= myList.stream()
             .filter(e-> !e.isEmpty())
             .map(String::toUpperCase)
                .collect(Collectors.groupingBy(
                        f->f,
                        Collectors.counting()));
        return "output  -> " +map;
    }


    public String LabdaExperssion(){
        //docaluclation


        return null;
    }
}

