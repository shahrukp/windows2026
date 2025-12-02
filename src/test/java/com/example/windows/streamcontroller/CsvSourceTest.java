package com.example.windows.streamcontroller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class CsvSourceTest {
   Calculator calculator=new Calculator();

    // Via CSVsource
    @ParameterizedTest
    @CsvSource({
            "12 ,8 ,20" ,// output is 20 here last is output like expected
            "12 ,2 ,14" // output is 20 here last is output like expected
    })

    @DisplayName("CsvDemo")
    public void  CsvSourceTest(int a, int b , int expected){
        System.out.println("output " +expected);
        Assertions.assertEquals(expected,calculator.add(a,b));

    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEvenNumbers(int number) {
       // assertTru(number % 2 == 0);
    }

    public void  CsvSourceTestOne(int a, int b , int expected){

        System.out.println("subtract " +expected);
        Assertions.assertEquals(expected,calculator.subtract(a,b));

    }

}
