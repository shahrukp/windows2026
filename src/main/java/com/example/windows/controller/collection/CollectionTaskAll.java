package com.example.windows.controller.collection;


import com.example.windows.employee.impl.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController

@RequestMapping("/collection/api/")
public class CollectionTaskAll {
    private EmployeeImpl v;

    @GetMapping("remove")
    public String removeDuplicateCharAndElement() {
        List<String> lists = Arrays.asList("AA", "BB", "CC", "aa"); //output AA,BB CC,
        Set<String> set = new HashSet();
        for (String itr : lists) {
            String touppercase = itr.toUpperCase();
            set.add(touppercase);
        }
        return "output " + set;
    }

    @GetMapping("map")
        public Map<String ,Long>  mapInterafce(){
            Map<String, Integer> maps=new HashMap();
            maps.put("one",13); // not thrread safe
         //   maps.put("one" ,1);   // data structure key value paire
          //  maps.put(null ,1);   // allow one null key
            maps.put(null ,2);   // present in java util pacakge
           // maps.put("one" ,1);   // not allow duplicate key
            maps.put("l" ,121);   //  multiple duplicate value allowed
            maps.put("l1" ,null);    // multiple  null value  allowed

        // iterator vs iterable
       Iterator<Map.Entry<String, Integer>> itr =maps.entrySet().iterator();
        Map.Entry<String, Integer> entry=null;
       while(itr.hasNext()){
            entry=itr.next();


       }

        if(entry.getKey() !=null && entry .getKey().contains("l")){
            System.out.println("the value is.. " + entry.getValue());
        }else{
            System.out.println(" key not found " );

        }



            return null;











    }
 //IMPORTANT NOTES () ->
   // Map<String, Integer> hashMap = new HashMap<>();
   // Map<String, Integer> syncMap = Collections.synchronizedMap(hashMap);

    // Adding entries to the synchronized map
     //   syncMap.put("Apple", 1);
      //  syncMap.put("Banana", 2);

    // Using synchronized block when iterating
    //synchronized(syncMap) {
      //  for (Map.Entry<String, Integer> entry : syncMap.entrySet()) {
        //    System.out.println(entry.getKey() + ": " + entry.getValue());
        //}
   // Using ConcurrentHashMap
    //Another option is to use ConcurrentHashMap
   // ex   Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
}
