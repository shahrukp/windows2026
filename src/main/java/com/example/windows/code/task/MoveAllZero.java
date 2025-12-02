package com.example.windows.code.task;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/move/zero/")
public class MoveAllZero {

    @GetMapping("move")
    public int moveAllZero(){
        int arr[]={1,0,23,5,0,3,6,0,2,0}; // move all zero left right
        int pos=0;
        // move non zero at first
        for(int i=0; i<arr.length;i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];// it move internally
                //  pos++;// it move only
                //  System.out.println("output is.. move non zzero  "+arr[i]);
            }
        }
            // fil with remaing/add at last
            while (pos<arr.length){
                arr[pos++]=0;
            }
                 // print the  final result result
            for(int x :arr){
                System.out.print("move zero at last " +x);
            }

            // MOVE ZERO AT FIRST
        // Step 1: Move zeros to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[pos++] = 0; // place zeros at front
            }
        }

        // Step 2: Fill the rest with non-zeros
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }

        // Step 3: Print final array
        for (int x : arr) {
            System.out.print("move zero at first " +x);
        }


        return 0;

    }

    public  int moveZerFirst(){
        int arr[]={1,0,23,5,0,3,6,0,2,0}; // move all zero at fist
       int pos=0;
        // Step 1: Move zeros to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[pos++] = 0; // place zeros at front
            }
        }

        // Step 2: Fill the rest with non-zeros
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }

        // Step 3: Print final array
        for (int x : arr) {
            System.out.print(x + " ");
        }

        return 0;
    }


    // move zero AT LAst via Stream API

    @GetMapping("zeros")
    public String moveZero(){

        int arr[]={1,0,23,5,0,3,6,0,2,0}; // move all zero left right
     List<Integer>  res= Arrays.stream(arr)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.partitioningBy(
                        e->e==0),
                        //divide zero and non zero
                         refObj->
                         {
                        List<Integer> nonZero=refObj.get(false);
                             List<Integer> zero=refObj.get(true);
                             nonZero.addAll(zero);
                             return nonZero;
                         }

                ));
        return "output is " +res;
    }



    // move all zero at end
@GetMapping("movex")
    public String moveX(){

        int arr[]={9,10 ,11, 0,1,0 ,3,4,7,2,0,5,6,0,2,0,4, 8}; // oiutptu 1, 24 ,5 6, 80 , 0 ,0,0,0,0

    List<Integer> n1=new ArrayList<>();
   // using old way ? get firt nonZero
    for(int i =0; i<arr.length;i++){
        if(arr[i] !=0){
            System.out.print("nozero");
            System.out.println(arr[i]);
            n1.add(arr[i]);
        }
    }
    List<Integer> n2=new ArrayList<>();
    // get all zero
    for(int i =0; i<arr.length;i++){
        if(arr[i] ==0) {
            n2.add(arr[i]);
        }
        }
    List<List<Integer>> n3=new ArrayList<>();

    n3.add(n2);
    n3.add(n1);


    List<Integer> reulut=Arrays.stream(arr)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.partitioningBy( e->e!=0),
                            refObj->{
                              List<Integer> nonZero =  refObj.get(true); // true 12,,4,
                                Collections.sort(nonZero);
                              Stream<Integer> stream= nonZero.stream().distinct();
                              System.out.println("remove duplicate " +stream.collect(Collectors.toList()));
                                List<Integer> zero =  refObj.get(false);    // false
//                             //   stream.flatMap(stream, zero); see laters
//                                 Stream<Object> x=Stream.of(stream, zero);
//                                 System.out.println(" after remove duplicate's " +x.collect(Collectors.toList()));
                              nonZero.addAll(zero);
                              return  nonZero;
                            }));
        return "n1 " +n3;
    }
}
