package com.example.windows.collection;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StribgSMethods {


    @Test
    public void anyTask(){


       String palindrome="babad"; //Find the Longest Palindromic Substring

        Set<Character>uniqueCharss=new HashSet();

       // palindrome.substring(0,palindrome.charAt(i));

       for(char s:palindrome.toCharArray()){
           uniqueCharss.add(s);
       }
           System.out.println(" uniqueCharss " +uniqueCharss);



        String str="aabgegcde"; // print duplicatea char // age
        Set<Character>uniqueChars=new HashSet();
        Set<Character>sh=new LinkedHashSet();

        for(char x:str.toCharArray()){
            if(!uniqueChars.add(x))
            sh.add(x);

        }

      // for(set.to)
      //System.out.println(set);
        for(char chrr:sh){
            //  System.out.println(chrr);
        }


    }
}
