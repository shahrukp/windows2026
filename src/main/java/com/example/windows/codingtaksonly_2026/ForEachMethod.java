package com.example.windows.codingtaksonly_2026;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ForEachMethod {


    public String forEachM(){

     List<Integer> list= Arrays.asList(12345,32,21,34,7,765,432,13,45,1,10);


        // print and than find max ?
        list.forEach(w->System.out.println(w));

        return  "record send to the consloe  !";
    }
}
