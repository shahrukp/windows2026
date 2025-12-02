package com.example.windows.collectionall.codes;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionAllinOne {


    @Test
    public void ListSetInterface(){

        List<String> list =new LinkedList();


// below are accpetedble
        list.add("one");
        list.add("one");
        list.add("one");
        list.add("one");
        list.add(null);list.add(null);
        list.add(null);
        list.add(null);
    System.out.println(list);// [one, one, one, one, null, null, null, null]

        Set<String> lists =new LinkedHashSet();
        // not acceptable
        lists.add("one");
        lists.add("one");
        lists.add("one");
        lists.add("one");
        lists.add(null);list.add(null);
        lists.add(null);
        lists.add(null);
        System.out.println(lists);  //[one, null]



    }





}
