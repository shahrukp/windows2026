package com.example.windows.code.task;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

public class RevserTheString {
    public String revserTheString(){
        // stream api

        String str="java";
        System.out.println("original " +str);

      String result=str.chars()
                .mapToObj(c->(char)c)
                .map(String::valueOf)
                .reduce("", (a,b)->b+a);
                   return result;

    }
//@GetMapping("/revser/line")
    public String revserSentences() {
    String str = "Im java developer"; // output  develper java im

 String [] strs=str.split(" ");
 StringBuilder sb=new StringBuilder();
 for(int i=strs.length-1; i>=0;i--){
   //  sb.append(strs[i]).append(" "); // <-- here
     System.out.print(strs[i]);// work fine no issue
 }
    return " output " ;

}

    public String revserSentencesViaStream() {
        String str = "Im java developer"; // output  develper java im

      String res= Arrays.stream(str.split(" "))
                .reduce("", (a,b)->b+a);



        return  "result()=> "   +res;
    }



    public String forChecker(){
        StringBuilder sb=new StringBuilder();
        String s6="shahruk dhanki";
        String re[]= s6.replaceAll("\\+s" ,"").toLowerCase().split(" ");
        //   String[] str = input.split(" ");

        for (int i = re.length-1; i>=0; i--) {
            sb.append(re[i]).append(" ");
            System.out.print
             ("result ");
            System.out.println(re[i]);

           // return "target  " +sb.toString().trim(); // revPara 0 ,1 took 1 only
        } return  "? " +sb.toString().trim();

} }
