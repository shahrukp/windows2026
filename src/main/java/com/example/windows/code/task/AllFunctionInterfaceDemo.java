package com.example.windows.code.task;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllFunctionInterfaceDemo {
     //                   return_type      methods               Remembers(notes)                                        Extra Behaviours

     // supplier  ()->       void             get(T t)              did not take parametrs and prodcue the result           Supplier<String> // no extra paramerts required
     // Consumer  () ->      void            accpet(T t)           take parameter and did not return result              Consumer<String> // no extra paramerts required
    // BiConsumer () ->      void            accept(T t, T1 t2)    take 2 parameters and did not return  result         BiConsumer<String , Integer> // no extra paramerts required
    //predicate  ()->        boolean        test(T t)               take one input arguments                         Prdicate<String> // no extra paramerts required
    //biPredicate  ()->      boolean      Test(T t1, T t2)            takes two parametrs                                BiPredicate<String , Integer> // no extra paramerts required
    // function  () ->       Object         apply(t t1)                  take one argument input                       Function<Ineteger, Integer>  here take one extra for hold the outptu
    // Bifunction  () ->       Object         apply(T t2, T t2)                  take one argument input                       Function<Ineteger, Integer , Integer>  here take one extra parametrs for hold the outptu
   // callable   () ->        Object           call()                            define a single method with no arguments called call.
    // runable ()   ->       void              void run()                  define a single method with no arguments called void run().
    // supplier (get )  note no bisupplier there
    public  String supplierFunction(){
        //There is no requirement that a new or distinct result be returned each time the supplier is invoked.

     List<Integer> numbers=Arrays.asList(10,20,30,40,10);
        List<Integer> n=new ArrayList<>();
        Supplier<Integer>  list=new Supplier<Integer>() {


            @Override
            public Integer get() {
                for(Integer i:numbers){
                    n.add(i);
                }
                return 0;
            }
        };


        // other ways 2
        for(Integer s:numbers) {

            Supplier<Integer> num = () -> s;
           Stream<Supplier<Integer>> stream=Stream.of(num);
            Stream<Supplier<Integer>> r=stream.distinct();
            System.out.println("outut ?" +num.get());
        }
     return  "output is send ";
    }

    // Consumer (accept)
    public String  consumerDemo(){
        // override default method 1 to 10 print even or odd prime


        Consumer<Integer> con1=new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                System.out.println("even numbers are "  +s);

            }};
        int num=0;
        while(num <=10){
            if(num % 2==0){
                con1.accept(num);
            }
            num++;
        }


        Consumer<String> consumer = s-> System.out.println(s);
        consumer.accept("shahruk pathan software engineer");

        System.out.println("consumer");

        return  "output send" ;
    }

   // BiConsumer(accept T1 , t T2 t)
    public  String  BiConsumerDemo(){
        // k v
        Map<String , Integer> maps= Map.of("Java", 20000 ,"Python",16000, "anular" , 18000,
                "Micorserivres", 55000 ,"HTML",3200, "NodJs" , 1300
        );
        BiConsumer<String , Integer >biConsumer =new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println("outptu  between prince 15000 to 20000  " +
                        "  the keys() -> "  + key     +"the values () -> "  +value);
            }};
        // whos prince between 15000 to 25000 let them
        Integer targetvalue=15000;
        Integer targetvalue2=20000;
        maps.entrySet()
                .stream().filter(e->e.getValue() >targetvalue && e.getValue() <=targetvalue2)
                .forEach(entry ->biConsumer.accept(entry.getKey() ,entry.getValue() ) );
        return "key and value genrate "  +biConsumer; // hashcode
    }


    public String prediacteFilter(){

        String  mobilenumber="919673885160";
        // check if number has 10 digti and it start from 91 if inidan number then return true
        String target="91";
Long s=mobilenumber.chars()
        .filter(e->mobilenumber.startsWith(target))
        .sorted()
        .skip(2)
        .count();

 Boolean b=Boolean.valueOf(String.valueOf(s));
Predicate<Boolean> predicate=new Predicate<Boolean>() {
    @Override
    public boolean test(Boolean result) {
        return result;
    }
};
       // predicate.test(b);
        System.out.println("false/true () -> " +predicate.test(b));


        return "result" +s; // ture
    }


    public String biPredicate(){

        BiPredicate<String , Integer> bi=new BiPredicate<String, Integer>() {
            @Override
            public boolean test(String s, Integer integer) {
                return false;
            }
        };
        Map<String, Integer> maps =
                Map.of("Tom", 28, "Jerry", 28, "Deadpool", 34);
        // get the  whos age 28 only
        Integer thresshood=28;
    List<String>  rr=  maps.entrySet().stream()
                .filter(e->e.getValue()==thresshood)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        return "outp-put " +rr;
    }



   // Function (apply)
    public   String FunctionInt(){

        Function<String, Integer> fuc=new Function<String, Integer>() {
            Function<String, Integer> func = s->s.length();
            @Override
            public Integer apply(String  t) {

                return func.apply(t); // outptu is 3
            }
        };

        Function<String, Integer> function = s->s.length();
        return   "funntional inteface " + fuc.apply("a") + // outotu is 3
                "outptu " + function.apply("pathan") ; // output is 6
    }


    public String biFunctionDemo(){
    Map<Integer , Integer>  deatils=Map.of(20000, 110, 50000, 130, 2000, 101, 29022,115,
                600, 118 , 7500, 112, 9484,1800);

    // get all key values where value is  equals == 10
        BiFunction<Integer , Integer , Integer> bifunc=new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer key, Integer value) {
                return key +  value;
            }};
        Map<Integer,Integer>r=deatils
                .entrySet()
                .stream()
                .filter(e->e.getValue()<10)
                // .map(e->e.getKey())
                .collect(Collectors.toMap(
//                        bifunc.apply(Map.Entry::getKey),
//                        bifunc.apply(Map.Entry::getValue));
                         Map.Entry::getValue,
                         Map.Entry::getKey));
        System.out.println(" output is" +r);
    Stream<Object> result=r.entrySet()
                .stream()
              .map(e->bifunc.apply(e.getKey(),e.getValue()));
        System.out.println(" output is for result" +result);
        return "outptu is () -> " +result.collect(Collectors.toList());
    }
    // predicate (method -> Test) // more for better understating
    public String predicateFunctional(){
        String str="mgm";
        Predicate<String> predicate =new Predicate() {

            @Override
            public boolean test(Object o)
            {
                return o.equals(str);
            }
        };
        boolean r= predicate.test(str);

        return "output " +r;

    }


    // callable -> import java.util.concurrent.Callable;
    public String callableFunction(){
      //  A task that returns a result and may throw an exception. Implementors define a single method with no arguments called call.
        List<Integer> list = Arrays.asList(10, 20, 30 , 40 , 50 );
        Callable <String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };


        return null;
    }

    //  void
    // A Runnable, however, does not return a result and cannot throw a checked exception.
   // The Executors class contains utility methods to convert from other common forms to Callable classes.
    public String runableFunction() throws InterruptedException {

        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                System.out.println("im void method from runnable interface");
            }};
        int num= 110;
        if(num >10){
          runnable.run();
          Thread t=new Thread();
          t.start();
          Thread.sleep(15000); // 15 seconds
            System.out.println("runable method");
        }
        return  "? ";}
    public String predicatess(){
        List<String> lists=Arrays.asList("aman" , "chamn" ,"jerry", "tom");
        Predicate<String> l=a->a.startsWith("c");
        Predicate<String> l2=a->a.length()>3;
        Predicate<Integer> age = a-> a>18;
        boolean rsult=age.test(19);//true
        List<String> rr=lists.stream()
                //  .filter(l) // apply predicate here
                .filter(l.and(l2)) //apply both same time s
                .collect(Collectors.toList());
        return "output " +rr;

    }
}
