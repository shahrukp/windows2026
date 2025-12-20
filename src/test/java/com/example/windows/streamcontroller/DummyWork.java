package com.example.windows.streamcontroller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


interface lambdExperssionDemo{
    public int doCalculation(int x, int y);
}

public class DummyWork {

    // for each use only
    @Test
    public void forEachDemo(){
        List<String> names=new ArrayList();
        names.add("shahrk");
        names.add("mahek");
        names.add("simmu");
        names.add("tom");
        System.out.print(names);
       // names.forEach(e->System.out
               // .println(e));
    }








    // optioanl class eamples

    @Test
    public void optioanlClassDemo() {
        int arr[] = {1, 2, 3, 4, 5, 6, 99, 77,};// check if 4 is present then print 4of not them print no value is 4 there



        //can you do same wiht old way

        for(int i =0; i<arr.length;i++){
            if(arr[i]==46){
                System.out.println("get the for" +arr[i]); // fcrh inde number not value
            }else {
                System.out.println("given value is not present ");
            }
        }


    Optional opts=Arrays.stream(arr)
                .boxed()
                .filter(e->e==4 )
                .findAny();
    if(opts.isPresent()){
        System.out.println(opts.get());// get the 4
        }else {
        System.out.println("no 4 is presnt");
    }}



    @Test
    public void findMissingnumberinArray() {

        System.out.println("true or false " +(3*0.1==0.3));
        int arr[] = {1, 2, 3, 5, 6, 7, 8,9, 10};//missing_number 4
        int min=Arrays.stream(arr).min().getAsInt();
        System.out.println("output is one  ? -> " +min);
        int max=Arrays.stream(arr).max().getAsInt();
        System.out.println("find  ma is 10 ? -> " +max);
        // expectedsum
      int expectedSum= IntStream.rangeClosed(min,max).sum();
        System.out.println("expectedsum sum  ? " +expectedSum);
        // actuamSum
     int  actuamlsum= Arrays.stream(arr).sum();
        System.out.println("orignal sum  ? " +actuamlsum);

        int missingNumer =expectedSum-actuamlsum;

        System.out.println("the missing number is ? " +missingNumer);

    }
    @Test
    public void lambdaExperssionDem(){
        // using lambda experssion


        lambdExperssionDemo ds=(int a, int b) -> {
            return  a+b;
        };
        System.out.println("otutput via lambda  " +    ds.doCalculation(40,40));
        // using annomous class
        lambdExperssionDemo dc = new lambdExperssionDemo() {
            @Override
            public int doCalculation(int x, int y) {
                return x+y;
            }
        };
        System.out.println("otutput " + dc.doCalculation(20,20));
    }
    @Test
    public void Fibonacci(){
        int a=10; // Output0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
     int tem =a;
     int b=0;
     int c=0;
     int d=0;
   for(int i=0; i<=a; i++){

       System.out.println(a+ " ,");
       a=b; // what will be here  0-10
       b=c;
       c=a+b;

   }}
    @Test
    public void swapNumberwithout3Variable(){
        int a=12;
        int b=20;
        System.out.println("original values are " +a +"and the b is " +b);

       a=a+b; // a is 32
       b= a-b;   // 32-20 12
      System .out. println(" the b is " +b);
           a=a-b;
        System .out. println(" the a is " +a);


    }

@Test
public void countOccurecs() {
    int arr[] = {1, 2,1,9 ,-34, 567, 9, 54}; // outptu  1=2, 2=1, 9=2
    // using stream api and old way

  Map<Integer, Long> mapss= Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()));

    System.out.println("✅ Using Stream API:");
    for (Map.Entry<Integer, Long> entry : mapss.entrySet()) {
        System.out.println(entry.getKey() + " = " + entry.getValue());
    }

 // System.out.println("the count occurecs " +results);



    Map<Integer, Integer> maps=new HashMap<>();
    for(int a :arr){
        maps.put(a, maps.getOrDefault(a,0)+1);
    }
    System.out.println("the occurenc number are ");
    for(Map.Entry<Integer, Integer> m:maps.entrySet()){
        System.out.println("outtput is " +m.getKey() +" & ocurence" +m.getValue());
    }

}

    @Test
    public void findMa() {
        int arr[] = {1, 2, -34, 567, 9, 54}; //find max via stream and old 567 nad min 1
        OptionalInt r = Arrays.stream(arr)
                // .boxed()
                .min();
        // .max();
        if (r.isPresent()) {
            System.out.println(r.getAsInt());
        } else {
            System.out.println("list is empty !");
        }
        int minValue = 0;
        // using old approch pusdo code
        for (int i = 0; i < arr.length; i++) {
            // find max/min
            if (arr[i] < minValue) {
                minValue = arr[i];

            }
    }
        System.out.println("min value is "+minValue);
}




    //revser the strings make ffirst each char as upper case

    @Test
    public void works2(){
        String str []={"heena ","shahruk ", "simmu","mahek"}; // output Heena Shahruk Simmu Mahek
        String s1= "";
        for(String sss:str){
          s1= Character.toUpperCase(sss.charAt(0))+sss.substring(1);
         //
            // System.out.println("output is " +s1);
        }

        // using stream api String r=(a==b )? "yes" : "no";
     String result =  Arrays.stream(str)
             .map(e->Character.toUpperCase(e.charAt(0)) +e.substring(1))
        .collect(Collectors.joining());

        System.out.println("result is via stream api  "+result);

    }



    @Test
    public  void findDuplicateElementsTheirCount(){
      String  []str = {"apple", "banana", "apple", "orange", "banana", "banana"};
      //Output: apple=2, banana=3


     Map<String,Long>  wip=Arrays.stream(str)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));
        Map<String, Long> dn= wip.entrySet()
                        .stream()
                .filter(entry ->entry.getValue()>1)
              .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue));
System.out.println(" dupicate string and count  " +dn);
    }
    @Test
    public void groupBylenthg() {
        //Given a list of strings, group them by their length.
        String[] str = {"java", "hi", "hello", "world"};
        //Output: {2=[hi], 4=[java], 5=[hello, world]}
        // // Method A: Declare an empty array (length 0)
        //String[] splits = new String[0];
        //
        //// Method B: Declare an empty array using an initializer list (more concise)
        //String[] splits = {};  String[] splits="";
        String[] splits = {""};
        Map<Integer,  List<String>> maps=new HashMap<>();
        for( String ss:str){
            int len = ss.length();
            maps.putIfAbsent(len,new ArrayList());
                maps.get(len).add(ss);
            }System.out.println("outptu is " +maps.entrySet());
        }
@Test
    public void  FindDuplicateElementsinanArray(){
        // find duplicae via stream api
        int[] arr={1, 2, 3, 4, 2, 7, 8, 8, 3}; //Expected Output: [2, 3, 8]

    int duplicateValuess=0;
    int  duplicate=0;
    for(int i=0; i<arr.length;i++) {
        for(int j= i+1; j<arr.length; j++) {
            if (arr[i] == arr[j]) {
                arr[j]=arr[i];
                duplicate=arr[j];
                arr[i]=duplicate;
                break;
            }
        }
    }
    System.out.println("Duplicate values are......" +duplicate);
    Map<Integer, Long>  arrList= Arrays.stream(arr)
            .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

    List<Integer> duplicateVlaues=arrList.entrySet()
                .stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
      System.out.println("duplicate values " +duplicateVlaues);

// using old apporch tarditional way use  Pseudocode formala




    }


    @Test
    public void reverseWordsinaSentenceKeepPunctuation(){

        //Reverse Words in a Sentence (Keep punctuation)
        String str="Hello, world!";
        System.out.println("origianl " +str);

        String [] strs =str.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=strs.length-1; i>=0; i--){
           sb.append(strs[i]);
            // Add space between words (not after last one)
            if (i != 0) {
                sb.append(" ");
            }
        }
        System.out.print("origianl vs loop " +sb.reverse());

    }


@Test
    public void  findAllDuplicatesinastring(){
        // Find All Duplicates in a String
      String  str= "programming";
       // Output: ["r", "g", "m"]
 Map<Object,Long>  g= str.chars()
            .mapToObj(r->(char)r)
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()));
   List<Object> duplicae =g.entrySet()
            .stream()
            .filter(entr->entr.getValue()>1)
            .map(Map.Entry::getKey)
            //.findAny();
                    .collect(Collectors.toList());

   System.out.println("duplicate char is  "+duplicae);







    }

@Test
    public  void replaceCharactersWithTheirFrequency(){
        //Replace Characters With Their Frequency
        String str= "aabbccd";

   Map<Character, Long> g=str.chars()
                .mapToObj(t->(char)t)
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));
   System.out.println(g.toString());
    }

//    StringBuilder result = new StringBuilder();
//    Set<Character> seen = new HashSet<>();
//
//for (char ch : str.toCharArray()) {
//        if (!seen.contains(ch)) {
//            result.append(ch).append(g.get(ch));
//            seen.add(ch);
//        }
//    }
//
//System.out.println(result); // Output: a2b2c2d1


    @Test
    public  void ReverseOnlyDigitsMixedStringDemo() {
        String str = "abc123def456";
        // Output: "abc654def321"

      char []c=str.toCharArray();
      StringBuffer sb=new StringBuffer();
        // extrct the digit
        for(char s:c){
           if(Character.isDigit(s)){
               sb.append(s);
           }
        }
        System.out.println("outptus " +sb.reverse());
        // replce digit with origianl string


        StringBuilder result = new StringBuilder();
        int digitIndex = 0;
       for(char c1 :c){
           if(Character.isDigit(c1)){
               result.append(sb.charAt((digitIndex++)));
           }else{
               result.append(c1); //keep the same/// keep the letter as it is
           }
       }
        System.out.println("outptus 2 " +result);
    }

@Test
    public  void ReverseOnlyDigitsMixedString() {
    String str = "abc123def456";
    // Output: "abc654def321"
List<Character> reversedDigits=str.chars()
      //  .filter(e->Character.isDigit(e))
        .filter(Character::isDigit)
       .mapToObj(e->(char)e)
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
System.out.println(" isDigit" +reversedDigits);

// Step 2: Replace digits in original string with reversed ones
    StringBuilder result = new StringBuilder();
    Iterator<Character> digitIterator = reversedDigits.iterator();
    str.chars().forEach(c -> {
        if (Character.isDigit(c)) {
            result.append(digitIterator.next());
        } else {
            result.append((char) c);
        }
    });
    System.out.println(" final outptu " +result);
}



    @Test
    public void firstNonrepeatingChar(){
        //Find the First Non-Repeating Character in a String
        String str="swiss";

    Map<Object,Long>   chr=str.chars()
              .mapToObj(t->(char)t)
                .filter(e->str!=null)
           // .filter(e->!str.isEmpty())
                .collect(Collectors.groupingBy(
                      //  f->f,
                        Function.identity(),
                        Collectors.counting()));

        Optional<Object> result=chr.entrySet()
                        .stream()
                                .filter(entry->entry.getValue()==1)
                           .map(Map.Entry::getKey)
                                        .findFirst();
if(result.isPresent()){
    System.out.println("frist non repeating char is  " +result.get());
}else {
    System.out.println("list is empty !");
}

    }




    @Test
    public void checkPangram(){
        //
        // Definition: A string is a pangram if it contains every letter of the alphabet at least once.
       String str="The quick brown fox jumps over the lazy dog"; //→ ✅
        String chAlp="";
   //  String str1= str.replace(" \n+", " ");// remove space and symboll and comm etc from string
Set<Character> r=str.toLowerCase().chars()
        .filter(Character::isLetter)
        .mapToObj(c->(char)c)
     //   .mapToObj(c->String.valueOf(c))
        .sorted()
       .collect(Collectors.toSet());
     //   .collect(Collectors.joining());

        System.out.println(r.size() == 26 ? "✅ Pangram" : "❌ Not a Pangram");
Set<Character> set=new HashSet<>() ;//use for remove duplicatae

        set.addAll(r);

        if(set.size()<26){
            System.out.println("not a paragrm ");
        }


   System.out.print(" ? " +set);
        for(char i='a' ; i<='z'; i++){
            chAlp +=i;
        }
       char [] al=chAlp.toCharArray();

        Arrays.sort(al);

        if(set.contains(al)){
            System.out.println(" pangram -Yes");
        } else {
            System.out.println("pangram-No");
        }
        System.out.print("ch " +chAlp);



    }
    @Test
    public void stringAnagram(){
        String resultOne="";
        String resultTwo="";
        String str="listeNko";
        String str1="sileNt";
       char[]chr=str.toCharArray();
        char[]chr1=str1.toCharArray();
        Arrays.sort(chr1);
        Arrays.sort(chr);
        if(Arrays.equals(chr,chr1)){
        System.out.println("yes-Anagram");
        }else {
            System.out.println("No-Anagram");
        }
        // uisng stream api
     List<Character> fc=str.chars()
                .mapToObj(c->(char)c)
           //  .filter(e->e .Character.toUpperCase(e))
                 .sorted()
                .collect(Collectors.toList());
        List<Character> fcc=str1.chars()
                .mapToObj(c->(char)c)
                //  .filter(e->e .Character.toUpperCase(e))
                .sorted()
                .collect(Collectors.toList());


        // checks 2 string
     boolean r= str.toUpperCase().chars()
               // .mapToObj(g->(char)g)
             .mapToObj(t->String.valueOf(t)) //new ways
                .sorted()
                .collect(Collectors.joining())
                .equals(str1.toUpperCase()
                        .chars()
                       // .mapToObj(h->(char) h)
                        .mapToObj(t->String.valueOf(t))
                        .collect(Collectors.joining()));
     System.out.print(r);






     String result=(fc.equals(fcc)) ?" yes " :" no ";
     System.out.print("output is " +result);








    }
    //Check if a String is an Anagram of Another



    @Test
    public void checkPalindomr(){








      //  Check if a Number is an Armstrong Number
        int num=153;

//        while (temp != 0) {
//            temp /= 10;
//            count++;
//        }

        // num is a primitive int, not an object.so we cant take like int size= num.length();

        int result =0;
        int original= num;
        int digitSize=String.valueOf(num).length();
        while(num !=0){
           int lDigit=num %10; //get the last digit;
            // dont use this digit * eahc time instead use
         //   result+=lDigit*lDigit*lDigit*lDigit*lDigit;
            //       origial number , length
            result+=Math.pow(lDigit,digitSize);
         // int mahts=Math.abs(lDigit*3);
            num = num / 10;
        }
        System.out.println("the squre is " +result);
        if (result==original){
            System.out.println("armostrong Yes  " +result);
        }else{
            System.out.println("armostrong No   " +result);
        }

 //check give string and number is check Palindomr yes or not;

        //convert into string
      String strNum=Integer.toString(num);

      // quick convert int to string and string to int
       // String strNum = Integer.toString(num);
        //String reversed = new StringBuilder(strNum).reverse().toString();
      //using stream api
    String newString = strNum.chars()
                .mapToObj(ch->(char)ch)  // what this do exat ?
                .map(String ::valueOf) // what this do ? may be convert into stirng
                .reduce("",(a,b) ->(b+a));// what this do reduce ?
        //convert back to int
        System.out.println("newstring" +newString);
       int newNum=Integer.parseInt(newString);
        if(newNum==num){
            System.out.println("Yes, give number is palindrome");
        }else {
            System.out.println("No ,give number is palindrome");
        }
        // other way

       /* Suppose temp is 123 and revNum is 0.
        Iteration 1:
        lastDigit = 123 % 10 = 3
        revNum = 0 * 10 + 3 = 3
        temp = 123 / 10 = 12
        Iteration 2:
        lastDigit = 12 % 10 = 2
        revNum = 3 * 10 + 2 = 32
        temp = 12 / 10 = 1
        Iteration 3:
        lastDigit = 1 % 10 = 1
        revNum = 32 * 10 + 1 = 321
        temp = 1 / 10 = 0
        After the loop finishes, revNum will hold the reversed number, which is 321 in this case.*/
       // int tem=num;
        int numS=0;
        int revNum=0;
        while (num !=0){
           int lastDigit =num %10; // get the last digit
         //   System.out.println("lastDigit" +lastDigit);
          // revnum=lastDigit+lastDigit*10;
            revNum = revNum * 10 + lastDigit; // appned or get last digit into revnum as hold stor
           num=num /10; // remove last digit
        }
        System.out.println(" The reversed number is " +revNum);
    }



    @Test
    public void rString(){
        //at least 3 ways
        String str= "aaa";
        String resul="";
        StringBuilder sb=new StringBuilder();
        // old apporch
        char [] chr=str.toCharArray();// convert into chr
        for(int i=chr.length-1; i >=0;i--){
           //resul += str.charAt(i);
            sb.append(str.charAt(i));
        }
        // here is mistake checdk object not content equality. below use tostring
        if(sb.toString().equals(str)){
            System.out.println("yes , give string  is palidrom... " +sb.toString());
        }else{
            System.out.println("not a palindrom... " +sb.toString());

        }
        System.out.println("output is... " +sb.toString());

       //2 rd way

        String strs=str.chars()
        .mapToObj(chrs->(char)chrs)
                .map(String::valueOf)
                .reduce(" ",(a,b)->b+a);
        System.out.println("output is 2 ... " +strs.toString().toUpperCase());


      // 3rd way
        StringBuffer sbuffer=new StringBuffer(str);
        sbuffer.reverse();
        System.out.println(" output is 3 " +sbuffer.toString().toUpperCase());

    }


    //Task: Sum of Squares of Digits in a String

    @Test
    public void Squares(){
        String number="2514";
        int count =0;
        //Convert the string to an integer.
      int squre = 0;
        int newnumber=Integer.parseInt(number);
        while (newnumber>=0){
            int lastdigit =newnumber%10;
            squre =lastdigit*lastdigit;
            count++;}
        System.out.println(squre);


    }


    @Test
    public void StringandDigtiRever(){

        String name="bca"; // ABC
        int number =321; //outptu 123;
      String result= name.chars()
                .mapToObj(c->(char) c)
                .map(String::valueOf)
                .reduce(" ", (a,b)->b+a);

      System.out.println("outptu is " +result.toUpperCase());
   String newRe ="";

     String newNumnber=String.valueOf(number);

    char c[]=newNumnber.toCharArray();
    for(int i =c.length-1; i>=0 ;i--){
          newRe+= newNumnber.charAt(i);
        }
    // convert back into digit
     int backToInt=Integer.parseInt(newRe);
    // int number = Integer.parseInt(str);
        System.out.println("original number  " + number);
        System.out.println("with revser the number  " + backToInt);



    }


    @Test
    public void revserStringandDigit(){


        String str ="aneeeh";
        int a=321;
       char []c= str.toCharArray();
       String result="";

       for(int i =c.length-1;i>=0;i--){
          result += str.charAt(i);
       }

       System.out.println( " output  " +result.toUpperCase());

        //.........work on digit
//        String




    }


    @Test
    public void doAnyTask(){
        String str ="cbA"; // outptu abC

    String result=str.chars()
                .mapToObj(c->(char)c)
                .map(String::valueOf)
                .reduce("" ,(a,b) ->b+a);

    System.out.println(result);
     // int lastchar=result.length()-1;
        String newStr = str.substring(0, 2).toLowerCase() +
                str.substring(2).toUpperCase();
    System.out.println(newStr);


    }

    // find max 5 samll digit
    @Test
    public void smallDigit(){
      //  int ar[]={11,2,3,45,6,7,876,5,43,234,5};
      List<Integer>  num= Arrays.asList(11,2,3,45,6,7,876,5,43,234,5);
        // five min values
     List<Integer> lists= num.stream()
             // .sorted((a,b) ->a.compareTo(b))
             .sorted((a,b) ->Integer.compare(a,b))
              .limit(5)
              .collect(Collectors.toList());
     lists.forEach(e->System.out.println("min values -> " +e));

     //five max values
        List<Integer> maxs= num.stream()
                //.sorted((a,b) ->b.compareTo(a))
                .sorted((a,b) ->Integer.compare(b,a))
                .limit(5)
                .collect(Collectors.toList());
       // maxs.forEach(e->System.out.println("max values -> " +maxs));
        System.out.println(maxs);
    }

    @Test
    public void StringRevser(){
        // revers the strings via multples ways
     String str="ameys"; // output Syema
        String result="";
       char[]r =str  .toCharArray();
       for(int i =r.length-1; i>=0;i--){
           result+=str.charAt(i);
       }
     String toUpperCase= String.valueOf(Character.toUpperCase(result.charAt(0))
              +result.substring(1));
      System.out.println(toUpperCase);
      // Using stream APIS
       String rs=str.chars()
                .mapToObj(e->(char) e)
                . map(String::valueOf)
                .reduce(" ",(a,b) ->b+a);
       System.out.println("via stream apis  " +String.valueOf(Character.toUpperCase(rs.charAt(0))
               +rs.substring(1)));

    }


    @Test
    public void maxMin3(){
        List<Integer> numbers=Arrays.asList(1,2,43,999,543,29);
       List<Integer> yes= numbers.stream()
                .sorted((a,b) ->Integer.compare(b,a)) // desending order
                .limit(3)
                .collect(Collectors.toList());
       System.out.println(" output " +yes);
    }

    @Test
    public void makeUpperCaseString(){
       // String[] strs=new String[] { "sayema", "simmu","hena" };
        String strr[]={ "sayema", "simmu","hena" };

        // without stream
        for(String s:strr){
        String result=    Character.toUpperCase(s.charAt(0))+s.substring(1);
        System.out.println(result);
        }

        // with stream
      String srt =Arrays.stream(strr)
                .map(e->!e.isEmpty()  ?
                        Character.toUpperCase(e.charAt(0))+
                        e.substring(1).toLowerCase() : e) // : e awalys false like ? true :false
                .collect(Collectors.joining(" , "));

        System.out.println( "via stream " +srt);




    }

    //find max and min
    @Test
    public void maxAndMin(){

   List<Integer> numbers=Arrays.asList(1,2,43,999,543,29); // max and min descending and asecndin order
// find max and min 3


        List outpu= numbers.stream()
        .collect(Collectors.maxBy(Comparator.comparing(Integer::intValue)))
                .stream().collect(Collectors.toList());

   // max by max method
     Optional max=  numbers.stream()
                        .max(Comparator.comparing(Integer::intValue));


        System.out.println("max value is  " +max);

   System.out.println("max value is  " +outpu);



}

    @Test
    public void countEachOccurence(){
 List<String> lists=Arrays.asList("AA","CC","DD","TT", "MM" ,"AA","CC","DD","TT" );




 Map<String,Long> output= lists.stream()
         .collect(Collectors.groupingBy(
                 f1->f1,
                 Collectors.counting()));
 if(output.isEmpty()){
     System.out.println("list is empty ");
 }
 output.forEach((values, occurence)->
                System.out.println(values +"occur times " +occurence));


    }




    @Test  // all posible ways
    public void reverseStrings() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to reverse:");
        String userValue = sc.nextLine();

        System.out.println("Choose method (a - Stream API, b - Loop, c - StringBuilder):");
        String method = sc.nextLine().toLowerCase(); // read user choice

        switch (method) {
            case "a":
                // Reverse using Stream API
                String streamResult = userValue.chars()
                        .mapToObj(c -> (char) c)
                        .map(String::valueOf)
                        .reduce("", (a, b) -> b + a); // removed space
                System.out.println("Reversed using Stream API: " + streamResult);
                break;

            case "b":
                // Reverse using loop
                String result = "";
                char[] chr = userValue.toCharArray();
                for (int i = chr.length - 1; i >= 0; i--) { // fixed loop condition
                    result += chr[i];
                }
                System.out.println("Reversed using loop: " + result);
                break;

            case "c":
                // Reverse using StringBuilder
                StringBuilder s = new StringBuilder(userValue);
                System.out.println("Reversed using StringBuilder: " + s.reverse());
                break;

            default:
                System.out.println("No matching method selected!");
        }
    }



    @Test
    public void stringD(){
        String str="india"; // output India , inDia, indiA

       String ress= Character.toUpperCase(str.charAt(0))+str.substring(1);
        System.out.println("outptu  " +ress); //India
       String middle= str.substring(0, 2)+Character.toUpperCase(str.charAt(2))+str.substring(3);
        System.out.println("middle  " +middle); //inDia
        int last=str.length()-1;
      //  String lastCharUppercase = str.substring(0, str.length() - 1) + str.substring(str.length() - 1).toUpperCase(); // indiA

        String g= str.substring(0, last)+Character.toUpperCase(str.charAt(last));
        System.out.println("last   " +g);//indiA
    }








@Test
    public void stringTask(){
        List<String> n = Arrays.asList("John", "arams", "Alice", "Bob", "Amy", "Charlie", "David");
   String res=  n.stream()
              .filter(r -> r.toLowerCase().startsWith("a")) // ✅ case-insensitive
                .collect(Collectors.joining(","));
   System.out.println("elemnets start with " +res);

   // convert all name to uppercase
  String toUpper=  n.stream()
            .map(String::toUpperCase)
            .collect(Collectors.joining(","));
    System.out.println("to upper case is " +toUpper);

    //Collects the results into a new list.
    List<String> newList=  n.stream()
            .collect(Collectors.toCollection(ArrayList::new));

    System.out.println("nto a new list. " +newList);
    }


    // unmodificable sttings(collectingAndThen)
    // cant change values once we make it as unmodificable

    @Test
    public  void unmodificable(){

        List<String> namess=Arrays.asList("jery" ,"tomy" ,"tom" ,"cartoon");

    List<String> unmodificable= namess.stream()
              .collect(Collectors.collectingAndThen(
                     Collectors.toList(),
                      Collections::unmodifiableList));

        // print the result
        System.out.println(unmodificable);

        // Attempt to modify it directly (this will throw an exception)
       // unmodificable.set(3, "animation"); // 💥 This line throws UnsupportedOperationException

        // This line won't be reached due to exception
      //  System.out.println("Modified List: " + unmodificable);


        // now try to modify cartoon to animation throw error
    List<String> modify=  unmodificable.stream()
                .map(e->e.replace("cartoon" ,"animation"))
            // .map(e -> e.equalsIgnoreCase("cartoon") ? "animation" : e)
                .collect(Collectors.toList());

// thorw error due to not allowed
        System.out.println(modify);

    }






    @Test
    public void  countOcc(){
        // find first repetaing char ->a / and also non repeating char  ->b

      String str="abacdz";  // 0=a, 3=c
        Map<Character, Long> f=  str.chars()
              .mapToObj(c->(char) c)
               .collect(Collectors.groupingBy(
                f1->f1,
                LinkedHashMap::new,
                Collectors.counting()));

   Optional<Character>  opts= f.entrySet()
                .stream()
               // .filter(e->e.getValue() ==1) // for non repeating char b
           .filter(e->e.getValue() >1) // for first repeating char  a
                .map(Map.Entry::getKey)
                .findFirst();
        // print the result
        System.out.println("  ---> "  +opts);


    }

    @Test
    public void MapChar(){
        System.out.println("map->key->values");
        Map<String,Integer> map=Map.of("aa" ,1,"iphone", 2, "oopo",3);
       // output


        //aa1
        //Iphone2  // only makes this as upper case I
        //oopo3

        map.entrySet()
                .stream()
                .map(entry -> {
                    String getkeys =entry.getKey();
                    Integer getvalues= entry.getValue();
                    if(getkeys!=null && !getkeys.isEmpty()){               // get first chart at 0
                     if(getkeys.contentEquals("iphone") && getvalues.intValue()==2) {
                         String r1 = String.valueOf(Character.toUpperCase(getkeys.charAt(0))
                                 + getkeys.substring(1)); // remening char
                         return r1 + getvalues;
                     }else{return getkeys +getvalues;
                     }
                    }

                    return  "null" +null;
                }).forEach(System.out::println);


    }










    @Test
    public void  firstCharToUpper(){










        String [] str= {"hello","iphone" };  // Hello ; 'H' ,'e','l','l','o';

       // using old approch
       for(String cc:str){                            // get first char        // get remening
      String s  =String .valueOf(Character.toUpperCase(cc.charAt(0))+cc.substring(1));
          // System.out.println(" --->" +s);


       }
       // using stream apis
        String strs="hello";

    String r= IntStream.range(0, strs.length())
                .mapToObj(i->i==0
                        ? String.valueOf(Character.toUpperCase(strs.charAt(0)))
                        :  String.valueOf(strs.charAt(i))) // (a==b) ?true : false
                    .collect(Collectors.joining());
    System.out.println(r);

    }







    @Test
    public void reverseString(){
        // via stream and loop

        String name="cab"; // bac   abc

        String output="";

        //uisng old approch loop

       char[]chr= name.toCharArray();

       for(int i =chr.length-1; i>=0; i--){

           output+= name.charAt(i);
       }

       System.out.println(" output "  +output);



        String result= name.chars()
                .mapToObj(c->(char)c) // comvert into char
                .map(String::valueOf)
                .reduce(" ",(a,b) ->b+a);

        System.out.println("output is "+result);

        // now print like a-z formate
  Collection<String> r=  name.chars()
                .mapToObj(c->(char) c)
                .map(String::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));


  // join back string
     String joined= r.stream()
                        .collect(Collectors.joining(""));

        System.out.println("a-z formate is "+joined.toString());

    }


    @Test
    public void countEachOccurncce() {
        String str="avbarvfrttMQ" ;

        // uisng old approch

        Map<Character, Integer> m=new HashMap();

      // char [] chs=str.toCharArray();
        for (char chrs :str.toCharArray()){
            m.put(chrs,m.getOrDefault(chrs,0) +1);}
        Iterator<Map.Entry<Character,Integer>> it=m.entrySet().iterator();
        while (it.hasNext()){
          Map.Entry<Character,Integer> entrys=it.next();
          //println the result
            System.out.println("str ->" +entrys.getKey() +"->" +entrys.getValue());

        }

    Map<Object,Long>  kv = str.chars()
            .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(
                        f1->f1,
                        Collectors.counting()));
             // count each occurence
       if(kv.isEmpty()){
            System.out.println("string is empty");
        }else{

            kv.forEach((chr, times)->System.out.println(chr +" occunrece time " +times));
        }







        List<String> lists = Arrays.asList("XX", "XX", "aa", "aA", "Fr", "fR", "Er"); // count each ouucnre aa=2 , fr=2, er=1


        // uisng old approch

        Map<String, Integer> map=new HashMap();
        for(String ss:lists){
           ss=ss.toUpperCase();
            map.put(ss, map.getOrDefault(ss,0) +1); // increement
        }

        Iterator<Map.Entry<String,Integer>> itr= map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
           // System.out.println(entry.getKey() +" occurne times- >" +entry.getValue());


        }



    Map<String, Long> count = lists.stream()
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(
                        f1 -> f1,
                        Collectors.counting()));
     if (count.isEmpty()) {
            System.out.println("list is empty !");
        } else {
         //   count.forEach((string, con) -> System.out.println(string + "->" + con));
        }

    }



















    @Test
  public   void dummyRecordStrings(){
        String name = "xasggxeaxgaeaxxeheexewkde"; // output is  xasggxeaxgaeaxXeheexewkde
       int target=4;
       int count=0;
      char[] chr= name.toCharArray();
      //for(int i=chr.length; i<=0;i++){
        for(int i=0; i< name.length();i++){
               if(name.charAt(i)==target);
               count++;
            if(count==target){
                          System.out.println(name.charAt(i));
                System.out.println(i);
                break;
            }else {
                System.out.println("??");
                break;
            }
      }







    }







    @Test
    public void Dummy() {
        String name = "asggeagaa";// check if e prestn then make it as uppercase as  asggEagaa if not return
        String result = " ";
        //"asgga" + "E" + "gaa" → "asggaEgaa"



        // return null;
        }

        @Test
        public void makeUpperCase(){

            int a=20;
            int b=23;

            Boolean r= (a==b)?true:false;
            System.out.println(" - > " +r);

            List<String> names= Arrays.asList("aa" ,"iphone" ,"oopo","realme"); // make  the frist char as uppercase output Aa,Iphone

            List<String> output = names.stream()
                    .map(e -> e.isEmpty() ? e : Character.toUpperCase(e.charAt(0)) + e.substring(1))
                    .collect(Collectors.toList());

            System.out.println(output);

        }



        }



