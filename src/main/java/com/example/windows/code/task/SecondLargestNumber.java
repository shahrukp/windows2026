package com.example.windows.code.task;

import java.util.*;

public class SecondLargestNumber {

public String  randomTask(){


    int[] num = {10, 20, 5, 20, 8,-1,3, 2,1,10};  // after remove duplicate -1 1,2,3,5,8,10,20
    // ascending
    List<Integer> list =new ArrayList<>();
    int x=0;
    Arrays.sort(num);
//    Collections.sort(list);



    for(int i=0; i<num.length;i++){
        System.out.println("ascending order " +num[i]);
       list.add(num[i]);

    }
    // descending
    for(int i=num.length-1; i>=0;i--){
        System.out.println("descending  order " +num[i]);
list.add(num[i]);

    }

    Set<Integer> set =new LinkedHashSet<>();
    // remove dplicate
    for(int i=0; i<num.length; i++){
        set.add(num[i]);

    }
System.out.println("after remove duplicate " +set);

    return "output remove duplicate " +set  +"asecending order" + list   +"desecding order" +list ;

}
    public  String SecondLargestNumber(){
        int[] num = {10, 20, 5, 20, 8, 10};
      //  Arrays.sort(num); // 5, 8 10, 10 ,20 ,20 , wihtout this sort the array
        // old approch
        // suppose second large numbner
        int lagestNumber = num[0]; // 0
         int temp=0;
        for(int i=0; i<num.length;i++){
         //   System.out.println("output is (as it is )" +num[i]); // sort  10, 20, 5, 20, 8, 10
            for(int j=i+1; j<num.length;j++){
                if(num[i] < num[j]){
                    temp=num[i];
                    num[i]=num[j];
                    num[j]=temp;
                }
                System.out.println("j for output " +num[j]); // 20, 5, 20, 8, 10
                 }}
        System.out.println("second highest number" +num[1]); // 20, 5, 20, 8, 10

        //   System.out.println("second large number is " +lagestNumber);

      int s= Arrays.stream(num)
                .boxed()
                .sorted(Comparator.reverseOrder())  // 20 , 20, 10 , 10, 8 5,
                .distinct()  // remove duplicate 5, 8 , 10, 20
                .skip(1)
                .findFirst()
                .orElse(0);
        return "second largest number " +s; // 10

    }




}
