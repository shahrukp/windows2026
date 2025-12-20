package com.example.windows.codingtaksonly_2026;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PredicateViBiPredicate {


// true  false
    public String prdicate() {
        List<Integer> numbers = Arrays.asList(1, 11, 2, 4, 5, 6, 41, 8, 765, 432, 90, 22, 38, 643, 2, 34, 55);
        {
            Predicate<Integer> objRef = checkValue -> checkValue == 90;

            List<Integer> out = numbers.stream()
                    .filter(objRef)
                    .collect(Collectors.toList());

            return "? ->  " + out;
        }

    }
    //
    public String biPredicate(){
        Map<String, Integer> maps = Map.of("Tom", 28, "Jerry",
                                           28, "Deadpool", 34,
                                           "Shahruk" ,29, "Shark",
                                           29 ,"SH", 29);

        // get/fetch records whos age (value) 28 only
        BiPredicate<String,Integer> biPred =new BiPredicate<String, Integer>() {
            @Override
            public boolean test(String startsWith, Integer age) {
                return  startsWith.startsWith("S")  &&  age==29 ;
            }
        };

        // using  lambda
        BiPredicate<String,Integer> objRef= (name,age)-> name.startsWith("S") && age==29;

  Map<String,Integer> bipr= maps.entrySet()
                .stream().
               // filter(e->biPred.test(e.getKey(),e.getValue()))
               filter(e->objRef.test(e.getKey(), e.getValue()))
                .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue));

        List<Map.Entry<String, Integer>> s=  bipr.entrySet()
                .stream()
                .collect(Collectors.toList());


        return  "biPredicate... ->  "+s;
    }
}
