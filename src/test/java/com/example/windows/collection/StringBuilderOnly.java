package com.example.windows.collection;

import org.junit.jupiter.api.Test;

public class StringBuilderOnly {

    @Test
    public void testMethods(){



        String str="im javv developer"; // replae v as a ouput is im java developer
        StringBuilder sb=new StringBuilder(str);
        sb.setCharAt(6 ,'a');
        System.out.println("new " +sb);
     String res="";
       char []c= str.toCharArray();

       for(int i =c.length-1; i>=0; i--){
          res += str.charAt(i);
       }
        System.out.println("revser the  " +res);

    }
}
