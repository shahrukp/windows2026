package com.example.windows.code.task;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {

// wont thorw the error

    public String  FailSafeDemo(){
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList
            =new CopyOnWriteArrayList();
copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(4); // upto the 4
    Iterator<Integer> itr=copyOnWriteArrayList.iterator();
    while(itr.hasNext()){
        copyOnWriteArrayList.add(3);
        System.out.println("the result" +itr.next());

    }

return "output "  +copyOnWriteArrayList;

}}
