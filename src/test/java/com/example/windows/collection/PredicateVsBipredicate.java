package com.example.windows.collection;


import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class PredicateVsBipredicate {


    @Test
    public void predicateTest(){
        Stream<Integer> str= Stream.of(1,23,4,7,6,7,89,10); // print between 1 to 10
        Stream<String> person= Stream.of("ztom, Jerry", "Tom", "shahruk","tomy"); // print between 1 to 10


        // Predicate: check if name starts with "T"
     //   Predicate<String> startsWithT = person -> person.getName().startsWith("T");
      //  Predicate<String> startsWithT = per -> person.stream().startsWith("T");

        str.filter(e-> e <=10).forEach(System.out::println);

        // Use stream and filter with predicate
//        per.stream()
//                .filter(startsWithT::test) // or .filter(person -> startsWithT.test(person))
//                .forEach(System.out::println);
//    }
    }

    @Test
    public void biPredicateTest(){
  // name and age
      Map<String,Integer> maps= Map.of("Shahruk" , 28 , "Tom" ,38, "Jerry" , 27 ,
                     "Deadpool" , 38, "Iron" ,38 );


      BiPredicate<String, Integer> bip =((keyname, valueage)
              ->keyname.startsWith("T") &&  valueage >30);
//       .filter(person -> ageFilter.test(person, 28) && nameFilter.test(person, "A"))

        //// BiPredicate to check if name starts with 'A' and age >= 28
        //        BiPredicate<String, Integer> nameAndAgeCheck = (name, age) ->
        //                name.startsWith("A") && age >= 28;
        //
        //        // Use stream to filter based on BiPredicate
        //        people.stream()
        //              .filter(person -> nameAndAgeCheck.test(person.getName(), person.getAge()))
        //              .forEach(System.out::println);
        //    }
      System.out.println(bip);
                // print the result via foreachy

        if(maps.isEmpty()){
            System.out.println("map is empty ");
        }else{
            maps.forEach((k, v)-> {
                if (bip.test(k, v)) {
                    System.out.println(k + "name and age is  " + v);
                }
            });

        }


    }


}
