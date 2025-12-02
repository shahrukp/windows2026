package com.example.windows.collection;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.type.descriptor.java.CharacterJavaType;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Strings {

    @Test
    public void stringMehtods(){
//You can only call .toUpperCase() on a String, not a String[].
        String n="one two three four   ";  // output One two three four
//Arrays.chars() is incorrect – Arrays doesn't have a chars() method

        //Arrays.stream(n.split(" ")) must use this
     //  String res=  n.chars() no
      // String result= Arrays.stream(n.split(""))
                     //  .split("") //.split("") doesn't belong after .chars() – chars() returns an IntStream of character codes, not strings you can split.
             //  .map(e->e.isEmpty() ? e: Character.toUpperCase(e.charAt(0) +e.substring(1)))
                //  .collect(Collectors.joining( ""));

     //  System.out.println( "output is"  +result);

        //System.out.println( " output is" +n.trim()); // only remove first and last space



//     String s=  n.chars()
//               .split("")
//               .replaceAll("\\s+")
//               .mapToObj(e->(char)c)
//               .map(e->String.valueOf(e.charAt(0))
//               .collect(Collectors.toList()));

     String[] s= n.split(""); // spilitin array
     String ss= n.replaceAll("\\s+" ,""); // remove all space

     //char c =Character.toUpperCase(ss.charAt(0));
     // String sss=  String.valueOf(s.toUpperCase().charAt(0) +s.substring(1));
      //  String ssss=  String.valueOf(Character.toUpperCase()+s.subString(0));
      // System.out.println("output " +sss);





    }

    @Test
    public void joinMethod(){
      List<String> names= Arrays.asList("Jhon", "Tom", "Jerry") ; //join via -
       String r= String.join("-" , names);
        System.out.println("output " +r);


    }

    @Test
    public void subStringMethod(){
        List<String> names= Arrays.asList("Jhon", "Tom", "Jerry") ; //join via -
       String target="m";

//     List<String> rr=  names.stream()
//               
//               .filter(e-> e.substring(0))
//               .map(Character.toUpperCase())
//               .collect(Collectors.toList());

     //String result= ( a>b && b>a) :true ? false;
                            String str= " Im java developer ";
                                            System.out.println("endwith ..." +str.endsWith("developer"));  //false
                                            System.out.println(str.endsWith("Hel"));   // false
                                            System.out.println(str.endsWith("llo"));   // true
                                            System.out.println(str.endsWith("o"));     // true

                                String r1=   Arrays.stream( str.trim().split(" +")) //So, " +" means: one or more spaces.
                                              .map(e->e.isEmpty() ?e
                                                      :
                                         Character.toUpperCase(e.charAt(0)) +e.substring(1))
               .collect(Collectors.joining(" "));






                                        System.out.println("output ..." +r1);
                                        char [] c={'a' ,'b','c','d'};
                                       String cvo= String.copyValueOf(c);     // use  convert char into string

                                         System.out.println("output " +cvo);    // output abcd
    //  List<String> r =
//          boolean d=    names.stream().filter(e->e.indexOf("m"))
//                       .map(String::toUpperCase)
//                               .collect(Collectors.toList());



     List<String> r =  names.stream().filter(e->e.contentEquals(target))
                .map(String::toUpperCase)
                .collect(Collectors.toList());


                                                                  
                         System.out.println("output " +r);        
    }

          // remove spcial symbool and pring only digt and string
    @Test
       public  void removeSpcialsymbool(){
                     String str="gryu%67@#$%667" ;
                 //  boolean s= str.matches("[a-zA-Z0-9]")  ;
               //    System.out.println(str.matches("[a-zA-Z0-9]"));


             // Remove all characters that are NOT letters or digits
           String cleaned = str.replaceAll("[^a-zA-Z0-9]", "");

           //To remove digits and letters from a string while keeping symbols and special characters, you can use the replaceAll() 
             String cleanedStr = str.replaceAll("[a-zA-Z0-9]", "");
            System.out.println(cleaned)     ;



    }

    @Test
    public void stirngPool() {
        String str = "im java developer "; //conver frist char as uppercse output  Im java developer

        //Find the Most Frequent Character
        String inputs = "mississippimmmmmmm";

        Map<Character,Integer> map=new HashMap(); // key value

        for(char c : inputs.toCharArray()){ // convert into char
            map.put(c,map.getOrDefault(c,0)+1);
        }
        char maxChar = ' '; // most frequen char
        int maxCount=0; //count;

        // appli loops
        // Step 2: Find the most frequent character
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }

           System.out.println(" count each char " +map);
        System.out.println(" most frquntly value occurnece   " +maxChar +" and "+maxCount);



        String input = "programming";// remove duplicat
        char[] chr = input.toCharArray();
        Set<Character> s = new LinkedHashSet();
        for (Character chrs : chr)   //"progamin"{
        {
            s.add(chrs);
        }
        // Build result from set
        StringBuilder result = new StringBuilder();
        for (char c : s) {
            result.append(c);
        }

        System.out.println("remove duplicate  set  " +s);
        System.out.println("remove duplicate  " +result);


//        char[] chrs = input.toCharArray();
//        int count = 0;
//
//        for (int i = 0; i >= chrs.length; i++) {
//            char f = inputs.charAt(i);
//
//            for (Character cr : chrs) {
//                //   input.charAt(cr)==input;
//                count++;
//            }

            System.out.println("output " );

//          if(f.chrs){
//              System.out.println(f);
//              count++;
//          }

        }
    }



//        if(!str.isEmpty()){
//           String ss= Character.toUpperCase(str.charAt(9)) +str.substring(1);

//            str.charAt(0) – gets the first character.
//            Character.toUpperCase(...) – uppercases it.
//            str.substring(1) – gets the rest of the string starting from index 1.
//            Combine both parts to get the desired result.
           // System.out.println("output " +ss);



















