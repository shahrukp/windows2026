package com.example.windows.code.task;

import java.util.Arrays;

public class re{


    public String reS(){

        String str=" shahruk khan pathan";

       String st=str.replaceAll("\\+s","");

    String result= st.chars()
                .mapToObj(e->(char)e)
                 .map(String::valueOf)// convert back int sting
                .reduce(" ",(a,b)->b+a);


    // revser the word itself ?

        String strs="im java developer"; // developer java im
       String spt[]=strs.replaceAll("//+s","").split(" "); // need space

    String r=Arrays.stream(spt)
                .map(String::valueOf)
                .reduce(" ",(a,b)->b+a);
    
        return "output ()-> " +result
                + "   \n revser the world () ->   "   +r; // output najtap ...

    }
}
