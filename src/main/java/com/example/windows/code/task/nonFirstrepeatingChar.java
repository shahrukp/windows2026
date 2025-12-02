package com.example.windows.code.task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class nonFirstrepeatingChar {

    public String nonFirstrepeatingChar(){

        String str="swpiss"; // outptu is w

        Map<String, Long> re=str.chars()
                //This gives you an IntStream (each character of the string as its Unicode int value).  // So for "swips" → [115, 119, 105, 112, 115].

                .mapToObj(c->String.valueOf((char)c))
                //  .map(String::valueOf)
                .collect(Collectors.groupingBy(
                        f->f,
                        LinkedHashMap::new, // maintian the order
                        Collectors.counting()));
        Optional s=re.entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst();

        return "output is " +s.orElse("non repating char not found");

    }

}
