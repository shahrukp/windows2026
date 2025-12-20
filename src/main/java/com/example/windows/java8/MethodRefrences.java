package com.example.windows.java8;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class    Printer {
    public String sayMessage(String meessga){
        return meessga;
}}
interface  Mehtodref{
    public int addvalues(int a, int b);
    static int doSubraction(int a, int b){
        return a-b;
    }

    default  String x(String message){
        return message;
    }
}

@RequestMapping("/api/method/refreences/")
@RestController
public class MethodRefrences {


   // type one refre to the static method
    //http://localhost:8081/api/method/refreences/ref
    @GetMapping("/ref")
public String callRandomMehtods() {
        // calling static methos via method refrences
        BiFunction<Integer, Integer, Integer> functional = Mehtodref::doSubraction;
        int xx = functional.apply(12, 8);
        System.out.println("method refernces" + xx);


        //  2 way nned to understand
        Mehtodref fun = Mehtodref::doSubraction;
        int re = fun.addvalues(12, 11);

        // calling static methos via lambda experssion
        int result = Mehtodref.doSubraction(22, 66);

        return "output is "
                + xx
                + "via lambda experssion" + result //outut is 1
                +" via mehtod ref but direct cal via interface " +re; //outut is 1




}


//type 2 , 2. Reference to an Instance Method of an Object of an Arbitrary Type
    //http://localhost:8081/api/method/refreences/arbittrary
    @GetMapping("/arbittrary")
   // Arbitrary: This means that the method reference can be applied to any object of the specified type, without knowing the specific object instance beforehand.
    //Type: This refers to the class or interface type of the object. For example, String, Person, Integer, etc.
    public String ReferencesToanInstanceMethod(){
        String str="java developer";
        Supplier<String> s = str::toUpperCase;
        List<String> strings = Arrays.asList("hello", "world", "java");

        // make uppercaase
     List res=strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
     String one ="one";
        String two ="two"; // make both upercase

        Function<String,String> sd =String::toUpperCase;

      String o= sd.apply(one);
        String t= sd.apply(two);


        return "output " +s.get()
                +" and the list " +res
                +"one and two outptu" + o  +"and two" +t;



    }

    // call methods via constrctors

    // type 3  Reference to a Constructor
    //http://localhost:8081/api/method/refreences/constructor
    @GetMapping("/constructor")
    public String methodReferencesViaConstrctors(){
            //public Student(String name, String address, long mobileNumber, String collegename) {
            Student student=new Student("shahruk", "at post dhanki-445207",
                    978655432,"MGM");
            // not  predefine function interface wont work bacuse they take only 2 para  as below and need to create custoem function interface as belwo
           BiFunction<String , String ,Student> s=
                   //Internally, you hardcoded mobileNumber=97838339 and college="MGM".
                   (name , address)-> new Student(name, address, 97838339,"MGM");       // // mwthod refernecs with constrcoor
      Student re= s.apply("shahruk","dhanki");

      // above you have hardcodeed but create custome functional interface

      CustomFunctioanlInterface cutomInterface= Student::new;
        Student fci= cutomInterface.customeFunctionInterface("tilubabu", "at post dhanki-445207",
                978655432,"MGM-SRTM");
        return "result()->" +re +" and print the records using the custome interface" +fci;
    }

    //3. Reference to an Instance Method of an Existing Object
    //objectName::instanceMethodName
   // http://localhost:8081/api/method/refreences/viaobject
    @GetMapping("/viaobject")
    public String  referencetoanInstanceMethodofanExistingObject(){
        //synatx
        //objectName::instanceMethodName
        //This type of method reference is used to reference instance methods of an existing object. The syntax for this type of method reference is:

        //Concept
        //
        //Here, you already have an object created.
        //
        //You use method reference with that object.
        Printerss p=new Printerss();
      Function<String,String> pp= p::sayMess;
        return " output () >" +pp.apply("hi im part of method refernse  work on object based ok !!");
    }

}


