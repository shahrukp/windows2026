package com.example.windows.collection2026;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RequestMapping("/map/concurrentmap/concurrenthashmap")
@RestController
public class MapConcurrentMapConcurrentHashMap {

    // http://localhost:8084/map/concurrentmap/concurrenthashmap/map

    @GetMapping("/map")
    public Map<String, Integer> mapInterface() {
      //  Map<String, Integer> map = new HashMap<>(); option stiring and interger
        Map<String,Integer> map = new HashMap<>();
        map.put("tom", 21);
        map.put("jerry", 22);
        map.put("tomm", 25);
        // map.put(null,21); // hold one null key
        map.put("jerrys", 22); // dupicate key not allowed
        return map;
    }

    @GetMapping("/concurrentmap") // inteerface
    public String conCurrMap() {
        ConcurrentMap<String, Integer> concurrentHashMap=new ConcurrentHashMap<>();
        concurrentHashMap.put("shahruk" ,17);
        concurrentHashMap.put("tom" ,23);
        concurrentHashMap.put("jerry" ,29);
        concurrentHashMap.put("J" ,29);
        concurrentHashMap.put("Shyma" ,29);
        concurrentHashMap.put("Shahruk" ,29);
        concurrentHashMap.put(null ,29); // null not allowed
        //print only
      Iterator <Map.Entry<String,Integer>> itr= concurrentHashMap.entrySet().iterator();
       while(itr.hasNext()){
          Map.Entry<String,Integer> m=itr.next();
          int age=29;
          if(m.getValue()==29){
              // print all 29 values
              System.out.println("get the result " +m);
          }
       }
        return null;
    }

    @GetMapping("/concurrenthashmap") // inteerface
    public void  concurrHashMap() {

        ConcurrentHashMap<String, Integer> concurrentHashMap =new ConcurrentHashMap();

        concurrentHashMap.put("shahruk" ,17);
        concurrentHashMap.put("tom" ,23);
        concurrentHashMap.put("jerry" ,29);
        concurrentHashMap.put("J" ,29);
        concurrentHashMap.put("Shyma" ,29);
        concurrentHashMap.put("Shahruk" ,29);
        concurrentHashMap.put("null" ,56);
        //print only
        Iterator <Map.Entry<String,Integer>> itr= concurrentHashMap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String,Integer> m=itr.next();
            int age=29;
            if(m.getValue()==29){
                // print all 29 values
                System.out.println("get the result " +m);
            }
        }
      //  return null;

    }
}
