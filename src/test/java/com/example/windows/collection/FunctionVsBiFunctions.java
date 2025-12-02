package com.example.windows.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionVsBiFunctions {


    @Test
    public void FunctionInterfaceTest() {
//Converting String to Integer
        Function<String, Integer> stringToInteger = Integer::parseInt;

        String str = "123";
        int number = stringToInteger.apply(str);
        System.out.println(number); // Output: 123


        // and


        List<String> strings = Arrays.asList("1", "2", "3");

        Function<String, Integer> stringToIntegerr = Integer::parseInt;

        List<Integer> numbers = strings.stream()
                .map(stringToInteger)
                .collect(Collectors.toList());

        System.out.println(numbers); // Output: [1, 2, 3]
    }


    @Test
    public void BiFunctionInterfaceTest() {

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        int result = sum.apply(10, 20);
        System.out.println(result); // Output: 30

        // and

        BiFunction<String, String, Boolean> compare = (a, b) -> a.equals(b);

        boolean results = compare.apply("Hello", "World");
        System.out.println(results); // Output: false

    }
}