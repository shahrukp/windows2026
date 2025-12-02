package com.example.windows.code.task;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/block/style/")
@RestController
public class BlockStyleForopeartion {

//localhost:/8080/block/style/check
    @GetMapping("check")
    public String forEachMehotd(){
     String str="java develper"; //if contain l then print complete else null
        char search = 'l'; // jis character ko search karna hai
        Arrays.stream(str.split(" "))
                .forEach(e->{
                 char[]chr=e.toCharArray();
                    boolean containsL = false;
                 for(int i=0;i<chr.length;i++){
                     if(chr[i]==search){
                         containsL=true;
                         break;
                     }
                    }
                 if(containsL){
                     System.out.println("yes char is present" +search );
                     System.out.println("yes char is present"  +e);
                 }else{
                     System.out.println("no  char is present" +search);
                 }
                });

        return  "result genrated !";
    }

    //localhost:/8080/block/style/check
    @GetMapping("predefine")
    public String PredefinedFunctionVariable(){

      // notes Agar tumhe Function ka use karna hai → to map() ke sath hoga:
       // Agar tumhe filter ke sath use karna hai → to Predicate<Integer> lena hoga:
        Function<Integer,Integer> str=e->e*5;
        List<Integer> number=Arrays.asList(12,76,34,5,67,8);

       List<Integer> result=number.stream()
                .map(str)
                .collect(Collectors.toList());

        return "the outptu is " +result;
    }
    @GetMapping("max")
    public String predicate(){
      List<Integer> findMax =Arrays.asList(1,2,3,-98,4,666,7,89,0);

     int result=findMax.stream().max(Integer::compare).orElse(0);
     System.out.println("the output " +result);
     Predicate<Integer> p=e->e==result;
    List<Integer>x=findMax.stream()
              .filter(p)
              .collect(Collectors.toList());
    // othe way
      Optional mx= findMax.stream()
                .min(Comparator.comparingInt(Integer::intValue));
      return "max is " +x  + "nad min " +mx.get();

    }

    // conver int to string and string to int

    @GetMapping("convertor")
    public String inttoStringAndStringtoInt(){
        int number=234;
        String n="42";

       String resul=String.valueOf(number);
        int in =Integer.parseInt(n);

        return "the "+resul +"and the int " +in;
    }



    //Prime Numbers: [3, 5, 7, 11, 17]
    //Non-Prime Numbers: [1, 4, 6, 9, 12, 15, 20]
    @GetMapping("prime")
    public String oddEvenPrime(){
int number=20;

// get the root
        System.out.println("sqrt" +Math.sqrt(number));
        String result="";
        boolean isPrime=true;
        // prime 1 and 2 id not prime
        if(number <2){
          return  "not prime ";
        }
        for(int i=2; i<=Math.sqrt(number); i++){
            if(number %i==0){
                isPrime = false;
                return "not prime ";
            }}
        return "prime number !";
    }


}
