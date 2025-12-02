package com.example.windows.code.task;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Arrays;
import java.util.Comparator;

public class FindTheSecondlargestElementInArray {



    public  String findSecondLargeElements(){

        int arr[] = {1, 2, 3, 5, 6, 8, 76, 9, 3}; //
        // 9, 76 , 76 , 9
        // using old approch
        Arrays.sort(arr); //1,2,3,4..9, 76
// supoose second large number
        int secondlarg=arr[0];
        for(int i=0; i<arr.length;i++){
            if(arr[i] >secondlarg){
                System.out.println("the second largest number is " +arr[i]);
                break;
            }

            System.out.println(arr[i]);
        }
   int x= Arrays.stream(arr)
                .boxed()
                .filter(e->e!=null)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(00);


        return "second large element in array " +x;
    }
}
