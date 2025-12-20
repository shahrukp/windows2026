package com.example.windows.collection_Lambda_2025;

import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@FunctionalInterface
interface  MethodRef{
      int addValue(int x, int t); // abstrct method keep
      static int addV(int a, int b){
        return  a+b;
    }
    // instal method as deafult
     default String say(String messaagDecodeName){

          return "welcome" +messaagDecodeName;
    }
}


@Component
public class MethodRefernce {
    public String callingAddValue() {
        // call static method one way
        BiFunction<Integer, Integer, Integer> r = MethodRef::addV;  // no need bifunnction see 2 way below
        int result = r.apply(12, 8);


        // 2 way
        MethodRef x = MethodRef::addV;
        int understandd= x.addValue(2,2);


        return "calling static method via method refrences ---> " + result +
                "static with 2 way "   +MethodRef.addV(23,56);

    }












    // call insttnce  method
    public String addInstMethod() {


        return null;

    }
}
