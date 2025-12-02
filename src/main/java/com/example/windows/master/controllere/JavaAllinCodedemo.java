package com.example.windows.master.controllere;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.windows.oopps.Serilizaable;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class JavaAllinCodedemo {

    public int armostrongNumber(){
        int num=153;


       int lens=String.valueOf(num).length();
     int value= String.valueOf(num)
                .chars()//"1","5","3"
                     .map(Character::getNumericValue) //"1","5","3"
             .map(digit ->
                     // custom power function using IntStream product
                     IntStream.range(0, lens)
                             .map(i -> digit)   // repeat digit "length" times
                             .reduce(1, (a, b) -> a * b) // multiply → power
             )
             .sum();
                System.out.println("intstream" +value);
        int lenghtss = String.valueOf(num).length();
        System.out.println("lenghtss is " +lenghtss);
         int len=num/2;
         int tem=num;
         int sum=0;
        System.out.println("origianl "+num);
        while(num!=0){
           int lastdigit=num%10;
           // sum+=lastdigit*lastdigit*lastdigit;
          sum+=Math.pow(lastdigit,lenghtss);
           num=num/10;

        }
        System.out.println("sum "+sum);
        if(sum==tem){
            System.out.println("yes amrostrong number ");
        }else{
            System.out.println("no amrostrong number else ");

        }

        if(sum!=tem){
            System.out.println("no amrostrong number ");
        }




        return 0;
    }


    public String factorialNumber(){

       int fac=1,n=5;
       for(int i=1; i<=n;i++){
             fac=fac*i;

       }
        System.out.println("facotirla number is "+fac);

        return "outptu is "+fac;

    }


    public String fabbonaccieSeriles(){
        int first=0;
        int one=1;
        int n=10;

        for(int i=0; i<n;i++) {
            int result = first + one; // 1
            first=one; //  1
            one=result;
            System.out.println("output is " + first);
        }
     return null;
    }


    public String factrorialNumber(){
        int num=5;
        int fac=0;
        while(num !=0){
            int lastdigit =num%10;
                fac=lastdigit*lastdigit *lastdigit;
                num/=10;

        }
        System.out.println("output is " +fac);

        return  "fac" +fac;
    }

    public String fabonacciSeries(){
        int number =10;
      int  first=0;
      int  second=1;
      int result=0;
     for(int i=0; i<number-1; i++){
         result = first + second;
        first=second;
        second=result;
        result=first;
        // print only even number
         if(result %2==0){
             System.out.println("print only fabbonacies  series "+result);}
         }


      return "output is " +result;
    }

    public void  threadSleepwait() throws InterruptedException {
        System.out.print("sleep for 5 seconds");
        Thread.sleep(15000);
        System.out.print("end");

    }
    public void completeableFutures() {
        CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                    }
                    return "hello";
                })
                .thenApply(mes -> mes + " from the completebaleFuture")
                .thenAccept(System.out::println);
        try {
            Thread.sleep(2000);

        } catch (Exception e) {
        }
    }

    public ResponseEntity<?> dateTime(){
        Date date=new Date();
   LocalDate localDate=  LocalDate.now();
            return  new ResponseEntity("time ->" +localDate,HttpStatus.ACCEPTED);
    }
    public String doWhatICan(){
      String str []={"abc", "efg", "hig"}; // revser the outptu as hig , efg , abc
       // Collections.reverse(str);
        for(String s : str){
            System.out.println("output is" +s);
        }
        return "output is ......";


    }

    public String revserTheString() {
        String str = "im java developer";
        String st[]=str.split(" ");
      List<String> r= Arrays.asList(st);
      Collections.reverse(r);
    String result= String.join(", " ,r);
    //another ways
        String strs="i'm java developer";
      String s[]= strs.split(" ");
      String res="";
      for(int i =s.length-1;i>=0;i--){
          res+=strs.charAt(i);
          System.out.println("output " +res);
      } return res;
    }
        public ResponseEntity<String> makeFirstEachCharUpperCase(){
        String [] str={"one", "two", "three", "four"};
           for(String s :str){
         String result= String.valueOf(Character.toUpperCase(s.charAt(0))+s.substring(1));
            System.out.println("output " +result);
           }

           // using stream
     Stream result=Arrays.stream(str)
                .map(e->{
                    return String.valueOf(Character.toUpperCase(e.charAt(0))
                            +e.substring(1));
        });
           System.out.println("using stream apis "+result.collect(Collectors.toList()));
        return  new ResponseEntity("count each char " +result.collect(Collectors.toList()) ,HttpStatus.ACCEPTED);
    }



    public ResponseEntity<String> fecthRecords(){
        System.out.println("im inside fecthRecodrs");
        // find duplicate give number array
        int arr[]={12,12,3,4,5,4,5,6,9,7,8,9,7}; // find all duplicate values
        // psudo code
        int count=0;
        for(int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                    System.out.println( "count duplicate numbers... " +count);
                    System.out.println( "duplicate numbers are " +arr[i]);
                }}}
        System.out.println( "count duplicate numbers... " +count);
        // find and count duplicaete numbers
    Map<Integer,Long> duplicaevalues=IntStream.of(arr)
             .boxed()
                .collect(Collectors.
                        groupingBy(
                                Function.identity(),
                                Collectors.counting()));

     List<Integer> duplicateOne=duplicaevalues.entrySet()
                .stream()
             .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
     System.out.println("duplicae values  "+duplicateOne);




        return new ResponseEntity("count " +count,HttpStatus.ACCEPTED);
    }
    public  String say(){
        return "Hello";
    }

    public  int add(){
        return 23;
    }

    // save Serilizable obj
public ResponseEntity<Serilizaable> saveSerilizaable(){
    try{
        Serilizaable serilizaable =new Serilizaable(  "shahruk_pathan" ,777.00, 788.0);
        String fileLocation ="E:\\DOWNLOAD_SOFTWARE\\projects\\window";
        File file =new File(fileLocation);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter =new FileWriter(file);
        if(fileWriter !=null){
            fileWriter.write(String.valueOf(serilizaable));
        }
    }catch (FileSystemNotFoundException e){
        return  new ResponseEntity("file not found " +e , HttpStatus.ACCEPTED);

    } catch (IOException e) {
        throw new RuntimeException("something went wrong " +e);
    }
    return  new ResponseEntity("WIP" , HttpStatus.ACCEPTED);

}





}
