package com.example.windows.code.task;

import java.util.HashMap;
import java.util.Map;

public class CountEachCharInString {


    public String countEachCharinString(){
        String str="shahruk khan pathan pathan x";
//        Map<String,Integer> countChar =new HashMap<String  , Integer>();
    // String[] s= str.split(" "); for word
        // remove the spacr
      String spaceremove=str.replaceAll("\\s+","");
        Map<Character,Integer> countChar =new HashMap<Character  , Integer>();
      char ch[]= spaceremove.toCharArray();
        for(char cc:ch){
            if(countChar.containsKey(cc)){
             countChar.put(cc,countChar.getOrDefault(cc ,0)+1);
            }// keep the remaing
            else {
                countChar.put(cc, +1);}
       }return "count "  +countChar;
    }
}
