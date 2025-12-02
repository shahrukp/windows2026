package com.example.windows.code.task;

import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArragramStringCheckNumber {


    public String arragramChecker(){


        String str="listen";

        String str1="listen";

        if(!(str.length()==str1.length())){
            return "not arrgagrm string";

        }
       char[]chr=str.toCharArray();
        char[]chr1=str1.toCharArray();
        Arrays.sort(chr);
        Arrays.sort(chr1);
        if(Arrays.equals(chr,chr1)){
            return "yes";
        }
        return "outptu genrated";
    }
    // using strea api
    public String arrgarmViaStream(){
        String s="abv";
        String b="abd";
  String sss=
        s.chars()
                .sorted()
                .mapToObj(cr->String.valueOf((char)cr
                )).collect(Collectors.joining());
        String res=
                b.chars()
                        .sorted()
                        .mapToObj(cr->String.valueOf((char)cr
                        )).collect(Collectors.joining());
        if(sss.equalsIgnoreCase(res)){
            return "both are the arrrgram ";
        }else{
            return "both are not arrgarem";
        }

    }


}
