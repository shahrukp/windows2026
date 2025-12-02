package com.example.windows.code.task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntToDoubleFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertCollectionIntoStreamAPI {



    public String  ConvertDiffertypeOfCollectionIntoStream(){

        //   arrays only............(1)
        int arr []={10, 20, 30 , 40 , 50 };
        IntStream s=Arrays.stream(arr);
        System.out.println("\"for arr int values 1 \" + ");
         s.forEach(e->System.out.println(e));

        Double d[]={10d, 20d, 30d , 40d , 50d}; // long integer warrpper class
        Stream<Double> doub=Arrays.stream(d);
        System.out.println("\"for arr Double values 2 \" + ");
        doub.forEach(System.out::println);

        String names[]={"Java" , "python", "Microservices","Html" , "jenkies"};
        System.out.println("\"for arr String values 3 \" + ");
        Stream<String> ss=Arrays.stream(names);


        // Collection only........(2)

        //a)
        List<String> nm= Arrays.asList("tom" , "jerry", "goku", "pikloo");
          nm.stream() // direct use stream
                  .map(w->{
                  String result= String.valueOf(Character.toUpperCase(w.charAt(0)) +w.substring(1));
                return "toUpperCase () -> "  +result;
                  });


                 // b)
                 Map<String , Integer> nameAge=Map.of("Tom", 32 , "Jerry", 18 , "goku" , 33);
                 Map<Object , Object>  maps=nameAge.entrySet()
                .stream()
                .filter(e->e.getValue() !=null && e.getValue() >20)
                .map(e->e.getKey())
                .collect(Collectors.toMap(
                       f->f,
                        f1->f1));

        System.out.println("\"for collection map nameAge values 1 \" + "  +nameAge);
        //....................................still need this to understand
       Boolean result=true;
      // Arrays.stream(result);
        System.out.println("\"for String   namevalues 1 \" + " );
       String str="shahruk pathan";
       str.chars()
           .boxed()
               .map(r->{
                   // revser the string 2  ways 1) nahtap, 2)pathan shahruk
                   return ss.filter(e->!e.isEmpty())
                           .reduce(" ", (a,b) ->b+a);
               });


       int numer =978383; // count digit-> 6
    long x=Stream.of(numer)
              .map(e->e!=null)
              .count();
System.out.print("count ystem.out.println(\"\\\"for digit count  values 1 \\\" + \"   " +x);



// genrate and iterate
      // Stream<Double> rand=Stream.generate(Math::random);
        System.out.print("generate (\"\\\"  values 1 \\\" + \"   ");
        Stream<Double> r=Stream.generate(() ->Math.random());
        int num=0;

    Stream uptoTen= Stream.generate(() ->num <=10); // print upto 10
        System.out.print("uptoten (\"\\\"  values 10 \\\" + \"   " +x);
      //  uptoTen.forEach(S->System.out.println(S));

      //  public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {
       r.limit(5).forEach(e->System.out.println(e));
      Stream<Integer> in= Stream.iterate(1, n->n*2);


        Stream<Integer> uptoelenven= Stream.iterate(1, n1->n1=11); // print upto 10
        System.out.println("uptoelenven "+uptoelenven);


        System.out.print("iterate (\"\\\"  values 1 \\\" + \"   " +x);
        in.limit(5).forEach(t->System.out.println(t));


        return  "output genrated ! ";

    }
}
