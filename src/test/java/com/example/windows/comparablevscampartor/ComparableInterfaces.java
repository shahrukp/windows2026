package com.example.windows.comparablevscampartor;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparableInterfaces {

    @Test
    public void test(){
        System.out.print("jo");
    }


    @Test
    public void Comaprable(){

       // Employee e=new Employee();
     List<Employee>e=Arrays.asList(
        new Employee("Shahruk" ,5609.00,"HR"),
        new Employee("Tom" ,19000.00,"TL"),
        new Employee("Jerry" ,2300.90,"Co"),
        new Employee("Tomy" ,44000.00,"Owner"),
        new Employee("S.Pathan" ,12344.33,"Employee"));
        //print descending order via comaprable interface

        Collections.sort(e);
        for(Employee ee:e){
            System.out.print("--->" +ee);
        }


    }


}
