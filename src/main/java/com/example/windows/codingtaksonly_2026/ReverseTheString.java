package com.example.windows.codingtaksonly_2026;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ReverseTheString {


// uising stream api

    public String reverseTheStrring() {
        String years = "6202";
        String result = years.chars()
                .mapToObj(e -> (char) +e)
                .map(String::valueOf)
                .reduce(" ", (a, b) -> b + a);

        return "outputi is " + result;
    }


    public String reverseTheStrring2() {
        String years = "6202";
        String res= "";
        char[] chr = years.toCharArray();
        for (int i = chr.length-1; i>=0; i--) {
             res += years.charAt(i);
            System.out.println("output is " + res);
          //  System.out.print("output is...... " + res);
        }
        return "years ->   called " +res;
    }

}