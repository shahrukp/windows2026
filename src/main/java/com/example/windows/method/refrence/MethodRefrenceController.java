package com.example.windows.method.refrence;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.BiFunction;
import java.util.function.Function;

//
//@RequestMapping("/met")
//@RestController
public class MethodRefrenceController {
//    public void doAllonce() {
//        Function<CustomeMethods, Integer> function = input -> input.a
//                + input.b
//                + input.c
//                + input.d +
//                input.e
//                + input.f
//                + input.g
//                + input.h;
//
//    }

// here we are calling the static method via method refrences
    public static String  callSataicMehtods(){



        BiFunction<Integer,Integer, Integer> biFunction = FunctionalInterface::doCalculaetor; // method refrence
       //int result= biFunction.apply(34,45);
          return "output is genrate !" +biFunction.apply(66,99);

          // call docalculationwith4 variables and create custom methods

     // BiFunction<Integer,Integer, Integer, Integer, Integer> ff= BiFunctionCustom :: ;


    }
    public static void main(String[] args) {
        System.out.println(MethodRefrenceController.callSataicMehtods());

        Function<CustomeMethods, Integer> customefunction = input ->
                input.a
                + input.b
                + input.c
                + input.d +
                input.e
                + input.f
                + input.g
                + input.h;

        //   MethodRefForIntsance p= MethodRefForIntsance::new;
        // instat method call via method refrenfce
//        MethodRefForIntsance d=new MethodRefForIntsance();
//      int result =d::addvalues;
//      System.out.println("outptu is " +result);
        // call via constrctor ?
      //  customefunction.apply(customefunction,Integer);


    }

}
