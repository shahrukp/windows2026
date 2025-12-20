package com.example.windows.intervew.taskparacites;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Paracites {
    @Test
    public void findNonrepeatingChar(){
        String str="ababsddtrppk"; //srk
       char[]chr=str.toCharArray();
       for(int i=0; i<chr.length; i++){
           int count=0; // reset the count
           for(int j=0; j<chr.length; j++){
               if(chr[i]==chr[j]){
                   count++;}}
           if (count==1){
               System.out.print(chr[i]);}
       }
       // using map
        Map<Character, Integer> map=new LinkedHashMap<>();
      for( char c: str.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }for(char cc:str.toCharArray()){
           if(map.get(cc)==1){
               System.out.print(cc);
           }


      }



    }


   // check give number is prime ? even or odd  factor the number and palindrome(palindrome like rever  string)
  // even or odd
    // prime
    // factorial number
    // palindrom
   @Test
   public void primeEvenOddPalindrom(){
       int number=234;
  int result=1;
       // factor the number 5*4*3*2*1=120
       for(int i=1; i<=5;i++){
           result=result*i;}
       System.out.print(result);

       // using stream api
    Optional<Integer> factor_number =IntStream.rangeClosed(1, 5)
               .boxed()
            .reduce((s,b)->s*b);
       System.out.print("stream apis  output "+factor_number.get());
    System.out.print(factor_number);

     //  palindrome
       int tem=number;
       int reverse = 0;
       while(number !=0){
           int lastDigit=number%10;
          reverse=reverse*10+lastDigit;
         number=number/10;
       }
       System.out.println("revser the number , "+reverse);
       if (reverse==tem) {
           System.out.println("palindrome, ");
       }else{
           System.out.println("not palindrome,");
       }
       // check even or odd
       if(number %2==0){
           System.out.print("even,");
       }else{
           System.out.print("odd,");
       }
       // check prime
       boolean isPrime= true;

       if(number <1){
           isPrime =false;
       }else {
           for(int i =2; i<=number/2; i++){
               if(number %2==0){
                   isPrime=false;
                   break;}
           }}
       if(isPrime){
           System.out.println("prime,");
       }else {
           System.out.print("not prime,");
       }

   }


    @Test
    public void findDuplicateChar(){
        String str="abaabddooim"; // find duplicate char
        // both traditional and stream api
      char []c=str.toCharArray();
     // Set<Character> set=new HashSet<>();
      for(int i=0; i<c.length ;i++){
          for(int j=i+1; j<c.length;j++){
              int  count =0;
              if(c[i]==c[j]){
                 count++;
                  if(count >1){
                      System.out.println("duplicate char " +c[i]);
                  }
              }}
        }
    }
    @Test
    public void countAndSumDigit(){

        int number =123456789; // 1+2+3+4= output is  -> 10;4

        int count=0;

      String s=String.valueOf(number); // convert into string

        for(int i=0; i<s.length();i++){
            count ++;
        }
        System.out.print("totoal digit is  "+count);
        // using stream
       String res=String.valueOf(number);
  int  r =    res.chars()
               //.mapToObj()
                       .map(e->e-'0')
                           .sum(); //output is 10
                              // .count(); output is 4
// using intstream
//      Long nu=IntStream.rangeClosed(number)
//                .boxed()
//              .count();
//                .collect(Collectors.counting());
      System.out.print("output is "+r);




        }




    @Test
            public void UpperCases(){
    String []str ={"abc","bcd" ,"ifg"}; // make the first char as uppcasrCase eg Abc , Bcd , Ifg
        // using strea
     String result= Arrays.stream(str)
                .map(e->Character.toUpperCase(e.charAt(0))+e.substring(1))
                .collect(Collectors.joining(","));
     System.out.println("output is "+result);
    }






@Test
    // count each char  oocurnce both string and array in give below
    public void onString(){
    System.out.println(5 + "3");
      String str ="kkhtuee";//count each occurnce  e g kk=2
      char []c=str.toCharArray();
    Map<String, Long> count=Arrays.stream(str.split(""))
            .collect(Collectors.groupingBy(
                    f1->f1,
                    Collectors.counting()));
    count.forEach((key, value)->System.out.println(key +"  and the oocurnce " +value));


   List<String>  names=Arrays.asList("AA","BB" ,"AA","RR","FF","RR");

   Map<String, Long> result=names.stream()
            .collect(Collectors.groupingBy(
                    f1->f1,
                    Collectors.counting()));
    System.out.println("count 2 " +result);
    }
    @Test
    public void testApi(){
        System.out.println("ruunning");

    }


}
