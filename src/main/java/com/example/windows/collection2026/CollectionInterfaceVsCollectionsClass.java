package com.example.windows.collection2026;


import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CollectionInterfaceVsCollectionsClass {


    // collection intereface
    public String CollectioNInterface(){



        return  null;
    }
    // collections utility class
    public String collectionS(){
       List<Integer> list= Arrays.asList(1,2,3,45,67,8,8,76,540);
   //find max
      Iterator<Integer> itr= list.iterator();

      while(itr.hasNext()){
        itr.next();
          // print only max value
      }
        return  "max value -> " +Collections.max(list);
    }
}
