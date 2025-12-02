package com.example.windows.code.task;

import java.util.Arrays;

public class ReverseTheString {





    public String revserTheString(){

        String str=" im java developer "; // Developer java im , repoleved avaj mi


     String [] strrr=str.split(" ");

       String re=Arrays.stream(strrr).filter(e->!e.isEmpty())
               .map(e->Character.toUpperCase(e.charAt(0))+e.substring(1))
                .reduce("",(a,b)-> b+a);

        String result =  str.chars()
                .mapToObj(e->(char)+e)
                .map(String::valueOf)
                .reduce(" ",(a,b)-> b+a);

        return "output is 2 - > " +result +" ouptu for 1 -> " +re;


    }
}
