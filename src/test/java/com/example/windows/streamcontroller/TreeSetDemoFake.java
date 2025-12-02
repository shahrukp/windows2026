package com.example.windows.streamcontroller;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;


public class TreeSetDemoFake {


@Test
    public void testTreeSet(){
    //e.getName().reversed() is incorrect because String in Java does not have a reversed() method.
    //✅ Original (method reference version):
//    Comparator<FakeRecordList> descendingOrder = Comparator.comparing(
//            FakeRecordList::getName, Comparator.reverseOrder());

//✅ Java 8 Lambda Equivalent:
    Comparator<FakeRecordList> desecdningorder =Comparator.comparing(e->e.getName()
            ,Comparator.reverseOrder());
//Issue  if i have removecomparator that needs
//    TreeSet needs to know how to compare the objects you're adding. You're adding objects of Main, but you haven’t told TreeSet how to sort them.
    TreeSet<FakeRecordList> fakeRecordLists =new TreeSet<>(desecdningorder);
    fakeRecordLists.add(new FakeRecordList("alice", 60000));
    fakeRecordLists.add(new FakeRecordList("zou", 45000));
    fakeRecordLists.add(new FakeRecordList("xoy", 45000));
    fakeRecordLists.add(new FakeRecordList("bob", 45000));
    fakeRecordLists.add(new FakeRecordList("charlie", 70000));
    for(FakeRecordList ss :fakeRecordLists ){
        String n= ss.name;
      char names=  ss.name.charAt(ss.name.length()-1); // get last char
        // make last char as upperCase output must be alicE, zoU, xoY, boB like ways
          String re  =String.valueOf(Character.toUpperCase(names));
          String sss= n.substring(0, n.length()-1)+re;
          System.out.println(sss +ss.salary);
    }



    }
}
