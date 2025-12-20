package com.example.windows.codingtaksonly_2026;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ReverseTheArray {



    public  String reverTheArrayAscendingOrder(){
        int arr[]= {1,2,33,56,7,8,76}; // ascending and descending order
        Arrays.sort(arr);
        //print the array
        List<Integer> l=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            l.add(arr[i]);
            System.out.println(arr[i]);
        }
                return "ascending order -> " +l;
    }

    public  String reverTheArrayDescndingOrder(){
        int arr[]= {1,2,33,56,7,8,76}; // ascending and descending order
        Arrays.sort(arr);
        //print the array
        List<Integer> l=new ArrayList<>();

        for(int i=arr.length-1; i>=0;i--){
            l.add(arr[i]);
            System.out.println(arr[i]);
        }
        return "desecnding order -> " +l;
    }


}
