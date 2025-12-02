package com.example.windows.code.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFasts {
// will throw the error like java.util.ConcurrentModificationException: null

    public String  FailSafeDemo(){
        List<Integer> copyOnWriteArrayList
                =new ArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(4); // upto the 4
        Iterator<Integer> itr=copyOnWriteArrayList.iterator();
        while(itr.hasNext()){
            copyOnWriteArrayList.add(3); // thorw the error
            System.out.println("the result" +itr.next());

        }
        return "output "  +copyOnWriteArrayList;

    }
}
