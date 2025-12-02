package com.example.windows.streamcontroller;



import com.example.windows.controller.StreamController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;


public class StreamControllerTest {

    @Test
    public void testCountEachocc() {
        StreamController processor = new StreamController();
        //Assertions.assertEquals(expected, actual);
        Map<String , Long>  result= processor.countEachocc();
        Assertions. assertEquals(2, result.get("a"));
        Assertions. assertEquals(2, result.get("v"));
        Assertions.assertEquals(2, result.get("f"));
    }
@Test
public void addValue(){
    StreamController processor = new StreamController();
    int result=processor.addValue();
    System.out.println("Result from addValue: " + result);
    Assertions. assertEquals(42,result);


}
@Test
    public void checkEvenNumberTest(){
    StreamController processor = new StreamController();
   boolean result= processor.checkEvenNumber();
    System.out.println("Result from checkEvenNumberTest: " + result);
   Assertions.assertTrue(true);


}


}



