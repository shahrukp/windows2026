package com.example.windows.codingtaksonly_2026;


import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FindSecondLargeElement {


    public String findSecondLargeElement(){

     List<Integer> num =Arrays.asList(12,3,2,4,789,8764,32);  //789
       Optional<Integer>  opt= num.stream()
                .filter(e-> e!=null)
              // .sorted(Comparator.comparing().reversed())
               .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        return  "second large number -> "+opt;
    }
}
