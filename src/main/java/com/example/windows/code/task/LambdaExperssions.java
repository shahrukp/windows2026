package com.example.windows.code.task;


import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface  ABC{

    public int addX(int x, int y); // abstrct method

    // it can have multiples default and static methods
    default  String defaultpassCode(String  code) {
        return code;

    }
    static void staticX(){// already static
        System.out.println("im static methods");
        }}
public class LambdaExperssions {
    public String callAboveMethods(){
        // we can call 2 ways (aanymous and lambda)
        // lambda
        ABC  abc =(int c , int b)->( c+b ); // without return and { }

        ABC abc1=(int a, int g) ->{ // with return
            return a+g;
            };

        List<Object> lis=new ArrayList();
        //  default via abc
     String xx= abc.defaultpassCode("Inf0009"); // output
           lis.add(xx);
        // static  via abc

      int x=  abc.addX(20, 19); // 39 outptu
        lis.add(x);
        ABC.staticX();
// annymous function
        ABC a=new ABC() {
            @Override
            public int addX(int x, int y) {
                return x+y; // 500
                 }};
         List<Object> lis1=new ArrayList();
         lis1.add( a.addX(250, 250)); // 500);
         lis1.add(a.defaultpassCode("anny1239")); // anny1239
          ABC.staticX(); // message
        return "Using lambda() -> " + lis
              +"    Using aanymous function -> " +lis1;
    }
}
