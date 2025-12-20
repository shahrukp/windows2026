package com.example.windows.collection2026;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class FailSafeVsFailFast {



    // fail fast will thorw the concurrent modification exception
    public String failFast(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);//
        list.add(5);

       Iterator<Integer>itr = list.iterator();{
           while (itr.hasNext()){
               list.add(4); // throw the error concurrent modification error
            // Integer x1= itr.next();
             System.out.println("?-> "  +itr.next());
           }
        }
        return "outptu  -> " +list;


    }

    // Fail Safe wont thorw the error

    public  String failSafe(){
        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>(); // present in java concurrent paclage
        list.add(1);
        list.add(2);
        list.add(3);//
        list.add(5);

        Iterator<Integer>itr = list.iterator();{
            while (itr.hasNext()){
                // won't thorw the error

                System.out.println("?-> "  +itr.next());
                list.add(4);
                break;
            }
        }
        Collections.sort(list);
        return "CopyOnWriteArrayList  -> " +list;


    }
}

