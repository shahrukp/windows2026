package com.example.windows.code.task;

import org.apache.coyote.http2.HpackDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequestMapping("/api/path/request/")
@RestController
public class GapCalulation {

    // note revser the string for code rev  and rever the whole para for code revPara
    // using path
  //  http://localhost:8082/api/path/request/get/rev
    @GetMapping("get/{passcode}" )
   // public String GapCalculation(@PathVariable String passcode ,String input )  {
        public String GapCalculation(@PathVariable String passcode)  {

            try{
                String input ="shaharuk pathan";
            String target ="revPara";
            String target1 ="rev";

    if(passcode.isEmpty() || passcode==null ){
        return  "please provide passcode";
    }
    if( !passcode.equalsIgnoreCase(target) && !passcode.equalsIgnoreCase(target1) ){
        return  "passcode not match !";
    }
    if(passcode.equalsIgnoreCase(target)) {
        String s6="shahruk khan";
       String re[]= s6.replaceAll("\\+s" ,"").toLowerCase().split(" ");
     //   String[] str = input.split(" ");

        for (int i = re.length-1; i>=0; i--) {
            System.out.println("target revPara " +re[i]);
            return "target  " + re[i]; // revPara 0 ,1 took 1 only
        }
    }
        if (passcode.equalsIgnoreCase(target1)) {
            char[] c = input.toCharArray();
            for (int i = c.length - 1; i >= 0; i--) {
                char result = input.charAt(i); // rev
                return "target1 " + result;
            }}}
            catch (Exception e)
        {return  "something went wrong !" +e.getMessage();
        }
        StringBuilder ss= new StringBuilder();
        String str="shahruk pathan"; // pathan shahruk
       String[] s= str.split(" ");// shahruk , pathan
       for(int i=s.length-1; i>=0;i--){
          // System.out.print (s[i]); // due to arrary
       }
        return "outptu sent ! " ;
    }
}
