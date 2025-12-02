package com.example.windows.streamcontroller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

     Calculator calculator =new Calculator();


     @BeforeEach
     public  void setup(){
         System.out.println("run before the all methods  inisatiled");
     }

    @BeforeAll
    static void initAll() {
        System.out.println("🔧 Before all tests (e.g. connect to DB)");
    }

    @Test
    public void addTest(){
      int result= calculator.add(20,30);//50
        System.out.println("additional result");
        Assertions.assertEquals(50,result );
    }

     @Test
    public void subtractTest(){
        int result= calculator.subtract(20,30);//-10
         System.out.println("subtract result");
        Assertions.assertEquals(-10,result );
    }

    @AfterEach
    public  void cleanup(){
        System.out.println("run after the all methods  !end");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("🧹 After all tests (e.g. close DB connection)");
    }


    // Via CSVsource
    @ParameterizedTest
    @CsvSource({
            "12 ,8 ,20" ,// output is 20 here last is output like expected
            "12 ,2 ,14" // output is 20 here last is output like expected
    })

    public void  CsvSourceTest(int a, int b , int expected){
            Assertions.assertEquals(expected,calculator.add(a,b));

    }

    public void  CsvSourceTestOne(int a, int b , int expected){
        Assertions.assertEquals(expected,calculator.subtract(a,b));

    }


}
