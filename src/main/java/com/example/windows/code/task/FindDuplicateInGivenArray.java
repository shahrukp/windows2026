package com.example.windows.code.task;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateInGivenArray {


    public  String findDuplicate(){

   List<Integer> duplicate=Arrays.asList(12,4,3,56,7,3); // outptu is 3
        int arr[]={12,3,68,9,0,3};

        for(int i=0; i<duplicate.size();i++){
            for(int j=i+1 ;j<duplicate.size();j++){

               // if(duplicate[i]==duplicate[j]){
                if(duplicate.get(i).equals(duplicate.get(j))){
                   System.out.println("duplicate" +duplicate.get(i));
                }

            }
        }
        return "output genrate !";


    }


    public  String findMultipleDuplicate(){

        List<Integer> duplicate=Arrays.asList(12,4,6,3,56,7,3,12,4,6,0); //
        List<Integer> list=new ArrayList();

        for (Integer x: duplicate){
            list.add(x);
        }

        for(int i=0; i<list.size();i++){
            for(int j=i+1; j<list.size();j++){
                    if(list.get(i).equals(list.get(j))) {
                        System.out.println("duplicate values" + list.get(i));
                    }
                }
            }
        return "output genrate !" ;

    }

}
