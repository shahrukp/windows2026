package com.example.windows.streamcontroller;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPITest {
// find first non repeating char ?
// find duplicate elements in list
// count each char occurnece in string and list
// reveser the sting via stream reduce and chararrya
// make first letter as uppercasae give list
// cehck palidormm paragrm
// sort elemtnet and find max min
// find second highest paid eemploye


    @Test
    public void findminElement(){

     List<String> list= Arrays.asList("laptop" ,"mobile" ,"LG" ,"vivo"); //output must be LG

     Optional lists =list.stream()
                        .collect(Collectors.minBy(Comparator.comparing(String::length)));
        System.out.println(lists);

        List<Integer> number= Arrays.asList(1,2,3,4,5,8,6,9); //output must be reversed
        // print descending order
     List<Integer> result=  number.stream()
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .collect(Collectors.toList());

        result.forEach(e->System.out.println(e));




        // remove specail char symbool  space touper case print only digti and alpabe
        String strr="@#$r5%^gU&*  T$ %^YHH";
        String t=  strr.chars()
                .filter(Character::isLetterOrDigit) // strr = strr.replaceAll("[A-Z^a-z0-9]", ""); // Remove special characters and spaces
                .mapToObj(c -> String.valueOf((char) c))
                .map(String::toUpperCase)

                .collect(Collectors.joining());
        System.out.println(t);








    }

    @Test
    public void charsChekc(){
        String str ="ACfrtg"; // check if t is present/conatins

        str.chars() //str.codePoints() // returns IntStream Both chars() and codePoints() return an IntStream, so you'll still need to use mapToObj to convert the integers to characters.
                .mapToObj(c->(char) c)
                .filter(e->e=='s')
                .findFirst() //ifPresentOrElse
                .ifPresentOrElse(System.out::println,
                        ()-> System.out.println("no suhc char is found !"));



    }

    //find duplicate value in give list
    @Test
    public void findDuplicate(){
      List<String> names=Arrays.asList("Apple" ,"banana" ,"AA" ,"mango" ,"VV" ,"Apple" , "vv" ,"AA" ,"graps");

    Set<String> r =names.stream()
                   .collect(Collectors.
                           toCollection(HashSet::new));

System.out.print(r);

// now find the duplicatae element
 // Optional<String> opt=
      List<String> s=
                names.stream()
                        .map(String::toUpperCase)
                .collect(Collectors.groupingBy(
                        fr->fr,
                        Collectors.counting()))
        .entrySet()
                .stream()
                        .filter(e->e.getValue()>1)

                                .map(Map.Entry::getKey)
                                        .collect(Collectors.toList());
/// Find duplicates
//        m.forEach((key, value) -> {
//            if (value > 1) {
//                System.out.println(key + " is a duplicate value!");
//            }
//        });

// Or, if you want to check if there are any duplicates at all
//        if (m.values().stream().anyMatch(value -> value > 1)) {
//            m.forEach((key, value) -> {
//                if (value > 1) {
//                    System.out.println(key + " is a duplicate value!");
//                }
//            });
//        } else {
//            System.out.println("no found ");

//        opt.ifPresentOrElse(e->System.out.println(e +" is the duplicate value  !")
//
//        , ()->
       System.out.print("list og all dupliate  !"+s);

//maps.forEach((key ,values)->System.out.println(key +"value occurence" +values));

    }

    @Test
    public void revserString(){
        String name="CBA";
        String res="";

       char []chr= name.toCharArray(); //convert into char arrays

        for(int i=chr.length-1; i>=0 ;i--){
          res+=  name.charAt(i);
        }
        System.out.println(res);








    }

    @Test
    public void secondLargeNumber(){
//Write a Java program to find the second largest number in an array.

        List<Number> num=Arrays.asList(4, 2, 91, 186, 5, 1, 8, 3, 7, 4,4 ,5,5, 6);

  Optional<Integer> second =num.stream()
           .map(Number::intValue) //    // Converts Number to Integer
           .distinct()
                   .sorted(Comparator.reverseOrder())
          .skip(1)
          .findFirst();

        second.ifPresentOrElse(value->System.out.println("second large number" +value) ,
                ()->System.out.print("list is empty !"));

//        int secondLargest = Arrays.stream(arr)
//                .distinct()
//                .sorted()
//                .skip(arr.length - 2) arr.length gives the total number of elements in the array.
//- 2 subtracts 2 from the total number of elements, which means we're skipping all elements except the last two.
//skip() method skips the specified number of elements in the stream.
//                .findFirst()
//                .orElseThrow();

    }

//    Why do you want to work at Capgemini?
//    How do you handle tight deadlines?
//
//    Describe a challenging project you worked on and how you overcame obstacles.
//            "At IHG, I was responsible for developing and maintaining REST APIs for the hotel booking system.
//    One of the challenges I faced was when we needed to update certain functionalities to align with new business requirements.
//    For example, the system initially didn’t allow customers to modify their reservation details after booking. Based on new business requirements,
//    I worked on modifying the API to allow customers to update their reservation details and improve error handling. I collaborated closely with the business
//    team to understand the requirements and ensure the solution met their needs. After making the necessary changes, I tested the API thoroughly,
//    ensuring data integrity and responsiveness, which resulted in a smoother user experience and reduced booking errors."
//
//    Write a program to find the Fibonacci series up to a given number in Python.

}
