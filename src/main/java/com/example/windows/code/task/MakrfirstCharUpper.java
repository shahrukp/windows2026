package com.example.windows.code.task;

public class MakrfirstCharUpper {



    public String toUpperCasess(){

        String str="java"; // output is Java

     String result =String.valueOf(Character.toUpperCase(str.charAt(0))+str.substring(1));

        String  s="im java developer"; // Im, java developer

       String []ss=s.split(" ");
        String result1 ="";
       for(String s1 :ss){
         result1+=String.valueOf(Character.toUpperCase(s1.charAt(0))+s1.substring(1));

       }
        return "single value outptu is " + result +" and paraghprse "+result1;
    }
}

