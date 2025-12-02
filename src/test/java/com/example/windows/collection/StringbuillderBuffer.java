package com.example.windows.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

public class StringbuillderBuffer {

    @Test
    public void stringpool() {


      //  Compress Repeated Characters (like basic RLE) Output: "a3b2c4d1"
      String n= "aaacccbbcd";

      Map<Character,Integer> m=new HashMap();
      for(char c :n.toCharArray()){
           m.put(c,m.getOrDefault(c,0 )+1);

      }

      StringBuffer s=new StringBuffer();
            s.append(m);

        System.out.println("stiil " +s.toString());



                //Find First Non-Repeated Character
        String str= "swiss";

        Map<Character ,Integer> maps=new LinkedHashMap();
     char maxCount=' ';

        for(char c:str.toCharArray()){
             maps.put(c,maps.getOrDefault(c,0) +1);
        }

        for(Map.Entry<Character ,Integer> entry: maps.entrySet()){

            if(entry.getValue()==1){
                System.out.println( "non-repeating frist char " +entry
                        .getKey());
                break;
              //  maxCount= entry.getKey();
            }
        }
System.out.println( "non-repeating frist char " +maps);
      //  System.out.println( "non-repeating frist char " +maxCount);








    //   // Swap First and Last Characters of a String
      String  input= "java";

        input.replace('a' ,'j');
                for(char chr:input.toCharArray()){

                }


    }

    @Test
    public void stringpools(){
// Final Working Version Using Two Pointers:
            String str = "a,b$c"; // outptu is c,b$a "c,b$a"


        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else {
                // Swap letters
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        System.out.println("Output is: " + new String(chars)); // c,b$a
    }


    @Test
    public void Pangram(){

      String sr= "programming"; // find all duplicate value
        Set<Character> s=new HashSet();

        for(char ss :sr.toCharArray()){

            if(s.size() !=0 && s.size() > 0){
                if(!s.contains(ss))
                    System.out.println("duplicate char are  :"  +s.toString());
            }
//            s.add(ss);
        }










       String str="The quick brown fo xjumpss over the lazy dog";
     String newString=str.trim().replaceAll("\\s+" ,"").toLowerCase();
     // convert into char

         Set<Character> set=new HashSet();
      boolean  found ;
         for(char c :newString.toCharArray()){
             set.add(c);
         }
         if(set.size() < 26){
             found =false;
         }else {
             found =true;
         }

 System.out.println( " the string found pargram as  " +found);
//       for(char i ='a' ; i <='z' ; i++){
//          //  System.out.println(" ?" +set.contains(i));
//        }

    }
    }
