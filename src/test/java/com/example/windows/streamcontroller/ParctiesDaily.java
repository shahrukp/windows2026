package com.example.windows.streamcontroller;

import com.zaxxer.hikari.util.FastList;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParctiesDaily {


    // find missing number in array via stream and old
@Test
    public  void findMissingNumber(){ // WIP
        int arr[]={1,2,3,4,6,7,8,9}; // 5 is missing number
        // pusdo logic
        int misisingNumber=0;
        for(int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]==arr[j]) {
                    arr[j] = arr[i];
                    arr[i] = arr[j];
                    misisingNumber = arr[j];
                    System.out.println("missing number " + misisingNumber);
                }
            }
        }
      // uisng stream api
    }
    // find the sum of all prime number upto n
    //what is prime number ? in java
    @Test
    public  void  sumOfALlPrimenumber(){
        int arr[]={2,4,4,6,78,765432,7,12,8,9,543}; // sum of all prime number
        // note prime number is that divide by 1 and itslef
         int primeNumbersum=0;
        // check below 2 if there terminate the programe
        for(int i =0;i<arr.length;i++){
        if(arr[i]<2){
            System.out.println("not a prime number");
        }
        }
        for(int i =0;i<arr.length;i++){
            if(arr[i] % 2==0){
               primeNumbersum +=arr[i];

            }

        }
        System.out.println("outptu is sum of total prime number :  " +primeNumbersum);

    }


    @Test
    public void replaceBySpace(){
        // replace all the space by the stirng ->%20
        String str1="%20";
        String str="tyeh jr d"; // outptu must be tyeh%20jr%20d
        System.out.println("original "+str);
     String spaceRemove=Stream.of(str.replaceAll(" ",str1 ))
                .collect(Collectors.joining());
     System.out.println("spaceRemove "+spaceRemove);


    }


    // supplier and consumer
    @Test
    public void supplierConsumerPredicate(){
        //Bipredicate
        Map<String,Integer> biPredicate=Map.of("thahruk" ,23 ,"Tom" ,22,"Jerry",33,"Bull",22);
        // get the result whos names is statwith  and t and age must be 23 below
    // BiPredicate<String, Integer>  biPredicate2=biPredicate=(name , age ) -> name.startsWith("t") || age <23;
     //print via foreach();
       // System.out.println("otutpu is "+biPredicate2);

        // predicate
        List<String> names=Arrays.asList("tom ", "john", "shahruk", "Jerry"); //filter based on predicate and get the start from t
     List<String> result= names.stream()
                .filter(e->e.startsWith("j") || e.equalsIgnoreCase("j")) // outptu must be jerry and john
             .collect(Collectors.toList());

     System.out.println("prdicate examples" +result);



        //supplier
        Supplier<Integer> nu=() ->40;
              int x= nu.get();
                //print the result
        System.out.println("output via supplier " +x);

        // Consumer
        Consumer<Integer> con = s ->System.out.println("output  via consumer " +s);
        con.accept(20);

    }


    @Test
    public void parallerArrya(){
        int arr[]={2,3,4,5,7,}; // sor both order
        Arrays.sort(arr);

    }


    @Test
    public void forEachDemo() {
        List<String> names = new ArrayList();
        names.add("shahrk");
        names.add("mahek");
        names.add("simmu");
        names.add("tom");

        // can you convert it inot map ?
        Map<String, Long> maps=names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
        Collectors.counting()));
        maps.forEach((key, values)->
                System.out.println("get the key" +values
                +"and the valeus " +key));
    }
@Test
    public  void ReverseOnlyDigitsMixedStringDemo() {
    String str = "abc123def456";
     // Output: "abc654def321" // revser the digit only

   char []c= str.toCharArray(); //abc

StringBuffer sb=new StringBuffer();
    for(Character cc : c){
      //  System.out.println(" ?" +cc);
        if(Character.isDigit(cc)) { // add or remove digit only
            System.out.println(" wihtout sb" +cc);
            sb.append(cc); // only digit

        }

    }
    System.out.println("sb " +sb.reverse());


    StringBuffer result=new StringBuffer();
    int digitreplace=0;
    for(char ccc :c){
        if(Character.isDigit(ccc)){
            result.append(sb.charAt(digitreplace++));
        }else{
            result.append(ccc);
        }
    }

    System.out.println("the result "+result);



}
}