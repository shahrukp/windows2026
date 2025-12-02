package com.example.windows.code.task;

import java.util.stream.IntStream;

public class CountDigit {


    public String countDigit(){
        int number=123;// 3
int count=0;
int result=0;int temp=number;
while(temp !=0){

   temp=temp/10;
    count++;
    System.out.println("count" +count);
}


        return "output is " +count;
    }

    // using stream api alwayes convert into string
    public String countDigitViaStream(){
        int num=12345;
  long x= String.valueOf(num)
            .chars()
            .count();
        return "output " + x;
    }
}
