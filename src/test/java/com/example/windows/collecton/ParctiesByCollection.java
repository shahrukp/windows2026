package com.example.windows.collecton;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParctiesByCollection {

    // hashset class vs treeset
    //HAshset  treeSet examples


    @Test
    public void hashsetTreeset(){
        HashSet<Integer> hashSet=new HashSet<>();
        Set<Integer> set=new HashSet();
        hashSet.add(4);
        hashSet.add(1); //?
        hashSet.add(19);
        hashSet.add(1);
        hashSet.add(1); // duplicate not allowed
        hashSet.add(1);
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add(null);// single null value is only allowed

        set.add(4);
        set.add(1); //?
        set.add(19);
        set.add(1);
        set.add(1); // duplicate not allowed
        set.add(1);
        set.add(null);
        set.add(null);
        set.add(null);// single null value is only allowed

        TreeSet<Integer> treeSet=new TreeSet();
        treeSet.add(4);
        treeSet.add(1); //?
        treeSet.add(19);
        treeSet.add(1);
        treeSet.add(1); // duplicate not allowed  also null not allowed
        treeSet.add(1);
      //  treeSet.add(null); //if tried to add  null(even if single one null then ->) then thorws java.lang.NullPointerException
        System.out.println( "output via hashst class" +hashSet.toString());
        System.out.println("output via set class" +set.toString());
        System.out.println("output via treeset class" +treeSet.toString());

    }//   4.5 What is difference between fail-fast and fail-safe ?
    @Test
    public void failFastFailSafe() {
        // fail fast thorw the exception see the code belwo
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // print the records
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            itr.next();
            // try to add more records
            list.add(26);  // thorw the error concurrentmodification
            // try to print the result

            System.out.println("outout will throw the error  " + list); // still print the result if even the error has thorw


            //  now fail fast
            // cant thorw error
            CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();
            copy.add(1);
            copy.add(2);
            copy.add(3);
            // print the records
            Iterator<Integer> itrs = copy.iterator();
            while (itrs.hasNext()) {
                itrs.next();
                // try to add more records
                copy.add(26);  //  they will not thorw the error concurrentmodification
                // try to print the result

                System.out.println("will not thorw the error  " + copy);


            }

        }
    }
@Test
    //ArrayListlinkedListArray emaples
    public void ArrayListlinkedListArray(){
      //ArrayList
        ArrayList arrayList=new ArrayList<>();
         arrayList.add(6);
        arrayList.add(3);
    arrayList.add(6);
    arrayList.add(3);
    arrayList.add(6);
    arrayList.add(3);

        arrayList.add(1); // multiple duplicate allowed
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null); // multiple nulls  values alowed
System.out.println("outut is arrayList ()-> "+ arrayList);

    //LinkedList
    LinkedList linkedList=new LinkedList<>();
    linkedList.add(66);
    linkedList.add(33);
    linkedList.add(66);
    linkedList.add(33);
    linkedList.add(66);
    linkedList.add(33);
    linkedList.add(11); // multiple duplicate allowed
    linkedList.add(null);
    linkedList.add(null);
    linkedList.add(null); // multiple nulls  values alowed ?
    System.out.println("outut is linkedList ()-> "+ linkedList);
    }



    // Set and List interface Example
    @Test
    public void SetlistInterfaceExamples(){
Set<Integer> set=new HashSet<>();
set.add(1);
        set.add(1); // duplicate not allowed
        set.add(3);
        set.add(null);
        set.add(null); // hold one null value

        System.out.println("output via set  " +set); // 1,3,null
// Listallowed both
        List<Integer> list=new ArrayList<>();
        list.add(null);
        list.add(1);
        list.add(1);
        list.add(4);// duplicate  allowed
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(null);// hold multiple null value

        System.out.println("output  via list  " +list); //1, 1,3,null , null





    }



    // HaSHTable Example
    @Test
    public void HaSHTableExample(){
// only allowed duplicate values .
        Hashtable<String,Integer> hashtable=new Hashtable();
        hashtable.put("Au", 1); // duplocate key not allowed and null key too
        hashtable.put("A0", 1);
        hashtable.put("Ab", 1);
        hashtable.put("sh", 1);
        hashtable.put("sht", 1);
        hashtable.put("A", 12); // duplicate  key not allowed
        hashtable.put("null", 6);    // not allowed null key
        hashtable.put("oo", 7); //multiple null values allwoed
        hashtable.put("pp", 0);
        System.out.println("output via HAshTAble " +hashtable.toString());

    }




    // hashmap



   // @Test
//    public HashMap<String, Integer> hashMap() {
//        return hashMap;
//    }

    @Test
    public void hashMaps(){
//        Map<String,Integer> map=new Map<String, Integer>() {
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean containsKey(Object key) {
//                return false;
//            }
//
//            @Override
//            public boolean containsValue(Object value) {
//                return false;
//            }
//
//            @Override
//            public Integer get(Object key) {
//                return null;
//            }
//
//            @Override
//            public Integer put(String key, Integer value) {
//                return null;
//            }
//
//            @Override
//            public Integer remove(Object key) {
//                return null;
//            }
//
//            @Override
//            public void putAll(Map<? extends String, ? extends Integer> m) {
//
//            }
//
//            @Override
//            public void clear() {
//
//            }
//
//            @Override
//            public Set<String> keySet() {
//                return null;
//            }
//
//            @Override
//            public Collection<Integer> values() {
//                return null;
//            }
//
//            @Override
//            public Set<Entry<String, Integer>> entrySet() {
//                return null;
//            }
//        };

        HashMap<String,Integer> hashMaps=new HashMap<>();
        hashMaps.put("Au", 1);
        hashMaps.put("A0", 1);
        hashMaps.put("Ab", 1);
        hashMaps.put("sh", 1);
        hashMaps.put("sh", 1);// duplicate key
        hashMaps.put("A", 12); // duplicate allowed no key not allowed
        hashMaps.put(null, 5); // valuea duplicate allowed as multiple
        hashMaps.put(null, 6);    // one null key allowed
        hashMaps.put("oo", null); //multiple null values allwoed
        hashMaps.put("pp", null);
        System.out.println("output via hashmap " +hashMaps.toString());


        Map<String,Integer> map=new HashMap<>();

        map.put("Au", 1);
        map.put("A0", 1);
        map.put("Ab", 1);
        map.put("sh", 1);
        hashMaps.put("sh", 1);// duplicate key
        map.put("A", 12); // duplicate allowed no key not allowed
        map.put(null, 5); // valuea duplicate allowed as multiple
        map.put(null, 6);    // one null key allowed
        map.put("oo", null); //multiple null values allwoed
        map.put("pp", null);
System.out.println("output via maps " +map.toString());

// make the hashmap thread safe and synchronized by follow
       Map<String, Integer> sy=Collections.synchronizedMap(hashMaps);
        System.out.println("when synchronized  is " +sy);




    }


}
