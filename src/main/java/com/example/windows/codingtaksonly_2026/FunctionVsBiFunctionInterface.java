package com.example.windows.codingtaksonly_2026;


import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class FunctionVsBiFunctionInterface {



    public String functionInter(){
        // do any taks? print 1 to 10?
        Function<Integer , Integer > function=new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer;
            }
        };
        int one=1;
        IntStream.rangeClosed(1,10)
                .forEach(o->System.out.println(+function.apply(o)));
        return  "one to ten ? -> " +function.apply(10);

    }
}
