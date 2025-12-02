package com.example.windows.codingtaksonly;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//@RequestMapping("/coding/task/")
//@RestController
@Component
public class CodingTaksOnly {
    public String dummyRevsers(){
        String[] str = {"aidni","av", "gd"}; // india, va ,dg , gd va , india
       // reuired return keyword
   Stream<String> reslut= Arrays.stream(str)
                .map(e->{
                    return e.chars()
                            .mapToObj(t->(char)t)
                            .map(String::valueOf)
                            .reduce("",(a,b)->b+a);
                });
   System.out.println("output is " +reslut);

        return null;
    }


    public String dummyRevser(){
        String[] str = {"aidni","av", "gd"}; // india, va ,dg , gd va , india
     List<String> result= Arrays.stream(str)
                .map(e->e.chars()
                                .mapToObj(c->(char)c)
                                .map(String::valueOf)
                                .reduce(" ",(a,b)->b+a))
                                .collect(Collectors.toList());

     System.out.print("output is "+ result);

        return null;


    }

    // reverse the string  and number via change the
    public ResponseEntity<String> revserStringNumber() {
        String str = "aidni";
        System.out.println("origianl  String  " + str);
        // using stram api and tarditional approch
        String revserString = str.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .reduce(" ", (a, b) -> b + a);
        System.out.println("revser the string  " + revserString);
        return new ResponseEntity("wip ", HttpStatus.ACCEPTED);
    }

    // url http://localhost:8080/coding/task/revserStringsArrays
    public ResponseEntity<String> revserStringsArrays() {
        String[] str = {"aidni","av", "gd"}; // india, va ,dg , gd va , india
        for (String s : str) {
            System.out.println("origianl  arrysstring s  " + s);
        }
        // using stram api and tarditional approch
     List<String>  result= Arrays.stream(str)
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .collect(Collectors.toList());
        StringBuilder stringBuilder=new StringBuilder();
        for(String s :result) {
            stringBuilder.append(s);
        }
   System.out.println("revser the  arrays string " + stringBuilder.reverse());
        return  new ResponseEntity(result,HttpStatus.ACCEPTED);
    }
    // url http://localhost:8080/coding/task/revserThenumber
    public ResponseEntity<String> revserThenumber() {
        int number=321; // 123
        int original =number;
        int revserNumber=0;
        while (number !=0){
            // get the last digit
           int lastDigit=number%10;
          //  System.out.println("lastdigit "+lastDigit);
            revserNumber =revserNumber * 10+ lastDigit;
          number=number/10;
    }
        System.out.println("revser the number "+revserNumber);

        return  null;
    }
    // url http://localhost:8080/coding/task/sumofDigit
    public ResponseEntity<String> sumofDigit() {
        int number=32112388; // 1+2+3=6

        int sum=0;
        while (number !=0){
          int lastFigit=number%10;
           sum=sum+lastFigit;
          number=number/10;
        }
        System.out.println("sum of digit" +sum);

        //using stream api
//        IntStream.of(number)
//                .boxed()
//                .map(e->e%10)
//                .sum()
//
        return  null;
    }


}
