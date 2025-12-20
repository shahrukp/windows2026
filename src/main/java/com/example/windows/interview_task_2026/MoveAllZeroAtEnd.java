package com.example.windows.interview_task_2026;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RequestMapping("/v5/")
@RestController
public class MoveAllZeroAtEnd {


  //  http://localhost:8084/v5/zero/move
    @GetMapping("/zero/move")
    public List<Integer> moveZeroAtEnd(){
     List<Integer> zero=Arrays.asList(2,9,0,10,20,0,7,05,0,4,0); // movezero at end
        List<Integer> zeroMove =new ArrayList<>();
        int zeros=0;
        int nonZeros=0;
        // using loop ?
        for(int i=0 ;i<zero.size();i++){
            if(zero.get(i)==0){
                zeroMove.add(zero.get(i));
                System.out.println("only zero" +zero.get(i));
                System.out.println("total  zero ? " +zeros);
                zeros++;}}
        for(int i1=0 ;i1<zero.size();i1++){
            if(zero.get(i1)!=0){
                zeroMove.add(zero.get(i1));
             //   System.out.println("only zero" +zero.get(i));
                System.out.println("total non zero ? " +zero.get(i1));
                nonZeros++;}}
        System.out.println("total non  zero" +nonZeros);
        return zeroMove;}


    // url endpoint http://localhost:8084/v5/move
@GetMapping("move")
public List<Integer> moveAllZero(){
        List<Integer> number=Arrays.asList(1,20,8,02,6,0,7,0,3,0,10,30,0,99);

  List<Integer> x=   number.stream()

              .mapToInt(e->(int)+e)
              .boxed()
              .collect(Collectors.collectingAndThen(
                      Collectors.partitioningBy(
                              e->e==0),
                      objRef ->{
                        List<Integer> zeros= objRef.get(true);
                          List<Integer> nonZeros= objRef.get(false);
                          nonZeros.addAll(zeros);
                          return  nonZeros; }));

        return  x;
}










}





