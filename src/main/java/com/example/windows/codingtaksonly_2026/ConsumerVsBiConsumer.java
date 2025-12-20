package com.example.windows.codingtaksonly_2026;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.logging.log4j.util.BiConsumer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class ConsumerVsBiConsumer {
    public String consumer() {
        // Consumer
        String code = "Java Developer !";
        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String code) {
            }
        };
        Consumer<String> con = refObj -> System.out.println(refObj);
        con.accept("Shahruk");
        consumer.accept("shahruk");

        return "-> ";
    }
    public String biConsumer() {
        // if 3 value  is there than return completed map or else return default  value as "map is empty"
        Map<String, Integer> maps = Map.of("A", 1, "B", 2,
                "C", 3, "D", 4);

        BiConsumer<String, Integer> biConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer v) {
                // it will print the resultS
                System.out.println("the result  keys are....: -> "+s
                          + "the values are ..: ->" +v);
            }
        };
        int targetValue=3;
       maps.entrySet()
                .stream()
                .filter(e->e.getValue()==targetValue)
               .collect(Collectors.toList())
                .forEach(entry->biConsumer.accept(entry.getKey(),(entry.getValue())));
        return "output is send ??";
    }
}
