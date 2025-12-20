package com.example.windows.collection2026;


import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/hashmap/hashtable/")
@RestController
public class HashMapVsHashTable {

    //htpp://localhost:8084/hashmap/hashtable/hashmap
@GetMapping("hashmap")
    public String hashMapClass(){

// not thread safe not synchorinized
        HashMap<String, Integer> hashMap=new HashMap<>();
        hashMap.put("shahrk",27);
        hashMap.put("Tom",17);
        hashMap.put("Jery",25);
        hashMap.put("Bumba",19); //will thorw errordue to duplicate key  not allowed
        hashMap.put("X",19);
    hashMap.put("X",19);
    hashMap.put("X",19);
    hashMap.put("X",19);

    //make hashMap as thread safe
   Map<String,Integer>  threadSafe =Collections.synchronizedMap(hashMap);

    threadSafe.put("X1",19); // duplicate values are allowe
    threadSafe.put("Bumba",19); // duplicate key not allowd
    threadSafe.put(null,19); // only one null key is allowed
    threadSafe.put(null,19); // only one null key is allowed
    threadSafe.put(null,19); // only one null key is allowed

    //   hashMap.put(null,17); // not allowed null as multiple
      Iterator <Map.Entry<String,Integer>> itr=threadSafe.entrySet().iterator();
      while(itr.hasNext()){
        Map.Entry<String,Integer> x= itr.next();
        if(threadSafe.containsKey("kom")){
            System.out.println("present  !");
        }
        System.out.println("x " +x);
      }
        return "? "  ;
    }


// already thread safe

    @GetMapping("hashtable")
    public String hashTable(){
        Hashtable<Integer,Integer> hashtable=new Hashtable<>();

        hashtable.put(1,22); // duplicate values are allowe
        hashtable.put(21,19); // duplicate key not allowd
      //  hashtable.put(21,19); // duplicate key not allowed
     //   hashtable.put(null,19); // thorw null pointer exceptions
        hashtable.put(28,19);

    return hashtable.toString();
    }
}
