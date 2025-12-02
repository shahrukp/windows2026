package com.example.windows.arrayvacollection;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ArrayCollection {





    @Test
    public void moveZeroRightLeftSideAgian() {
        int arr[]={0,23,0,30,0,9,03,4} ; // move zero left or right
     List<Integer> moveZero= Arrays.stream(arr)
       // List<Integer> rr= IntStream.of(arr)
                .boxed()// convert primitive to int[]
                .collect(Collectors.collectingAndThen(
                       Collectors.partitioningBy(
                               f->f==0),
                        // divided zero and remaning
                        refObj ->{
                        List<Integer> nonZero= refObj.get(false); //
                          //  System.out.println("nonZero ()->  " +nonZero); // collect nonzero

                            List<Integer> zero= refObj.get(true); //
                          //  System.out.println("zero ()->  " +zero); // collect zero

                            zero.addAll(nonZero);
                            return  zero;
                       }));

       // System.out.println("move zero  " +moveZero); // collect zero

        int zero;
        int noneZero;
        // move zero without stream api
        List<Integer> list =new ArrayList();
        for(int i =0; i<arr.length ;i++){
            // collect only zero
            if(arr[i]==0){
                zero=arr[i];
                System.out.println(zero);

             //   list.add(zero);
            }else{
               if(arr[i]!=0){
                   noneZero=arr[i];
                   System.out.println(noneZero);
                  // list.add(noneZero);
                   list.add(noneZero);
               }
            }
          //  System.out.println("outptu"  +list.addAll(zero));

        }



    }




    @Test
    public void moveZeroRightLeftSide() {

        int arr[] = {1, 0, 2, 30, 4, 0, 0, 0, 4,4,0,0, 0}; // move the zero left and right side (first and end )
        System.out.println("origianl arr");
        for(int a:arr) {
            System.out.print(a);
        }
        // output is like 0, 0, 0, 1,2,30,4,4,
        // output is like 1,2,30,4,4,0, 0, 0 this output .. WIP
        StringBuilder stringBuilder =new StringBuilder();
       int moveFirst =0;
        for(int i=0; i<arr.length; i++){
             // condtion
            if(arr[i]==0){
               arr[moveFirst++]=i;  //
                System.out.println("non-zero " +arr[i]); // collect zero
            }}
        while(moveFirst<arr.length){
              arr[moveFirst++]=0;
        }
        System.out.println("result" +arr); // collect zero

        // Using the stream api
     List<Integer> r=   Arrays.stream(arr)
                .boxed()
                .filter(e->e!=0)
                        .collect(Collectors.toList());
                        //.isPresent(t->t);
        System.out.println("zero only " +r);
        // sift to right side

        List<Integer> r1=   Arrays.stream(arr)
                .boxed()
                .filter(e->e==0)
                .collect(Collectors.toList());
        //.isPresent(t->t);
        System.out.println("move zero last  " +r1+r);

     // use flatmap to combine 2 array into single using flatmap

        List<Integer> flatMapResult=Stream.of(r1,r)
              .flatMap(e->e.stream())
              .collect(Collectors.toList());

System.out.println("outptu when appied faltMap "+flatMapResult);

       // r.stream().flatMap(r,r1.stream().flatMapToInt((Function<? super Integer, ? extends IntStream>) r1));
        //r.stream().flatMapToInt();



        }
    }


