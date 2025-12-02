package com.example.windows.java8;


import ch.qos.logback.core.spi.LifeCycle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface A{
    public String reversString(String strs);
}

public class LambdaExperssion {


    public String displayResult(){
    // uisng lambda and annymousc class

    A a =(String str) -> {
        String result="";
      char c[]= str.toCharArray();

      for(int i =c.length-1; i>=0;i--){
          result+=c[i];

      }
      return   "output is  " + result;
    };
    String s=a.reversString("cba"); // output abc


return s;
    }


    public  List<Integer> arrrayList(){
     List<Integer> list=Arrays.asList(12,3,4,5,4,543,4,67,87,543,2,2);
        // remove duplicate
      List<Integer> re= list.stream()
              .distinct()
                .sorted((a,b) ->b.compareTo(a)) // revser order
                .limit(3)
                .collect(Collectors.toList());
        // find max 3 value
        return re;





    }

}
