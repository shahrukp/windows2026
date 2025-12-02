package com.example.windows.collection;


import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerVsBiconsumerVsSupplier {



    @Test
    public void consumerTest(){

       Stream<String> consumers=Stream.of("Aark","Tom" ,"Jerry" ,"Tony");

        Consumer<String> con = name -> System.out.println(name);

        consumers
                .filter(name -> name.startsWith("A"))
                .forEach(con); // or just .forEach(System.out::println)
    }


    @Test
    public void biConsumerTest() {
        Map<String, Integer> maps =
                Map.of("Tom", 28, "Jerry", 28, "Deadpool", 34);
        // name      age

        // this wont work due to biconsumer return tyep is void this worl for biprdicate
//        BiConsumer<String , Integer> bicon= (keyname ,valueage)->
//                keyname.startsWith("T") &&  valueage >=25;
//    }
        //this bellow willwork
        BiConsumer<String, Integer> bicon = (name, age) -> System.out.println(name + " => " + age);

        //apply conditons
        maps.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("T") && entry.getValue() >= 25)
                .forEach(entry -> bicon.accept(entry.getKey(), entry.getValue()));
    }


    }
