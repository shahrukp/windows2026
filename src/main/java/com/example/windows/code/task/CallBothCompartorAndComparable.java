package com.example.windows.code.task;

import org.springframework.context.annotation.EnableMBeanExport;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CallBothCompartorAndComparable {


    public String Comparablesss(){
        List<Comparables> list = new ArrayList<>();
        list.add(new Comparables(3, "Aman"));
        list.add(new Comparables(1, "Pathan"));
        list.add(new Comparables(2, "Rahul"));

        Collections.sort(list); // by id
    // Collections.reverseOrder(); // by id dont need due to we can do from itself (class)
      //  Collections.reverse(list); // reveser by the name dont need due to we can do from itself (class)

        return  "the list as ascending order " +list;
    }


    public String ComparaTor(){

            List<Compartoresss> list = new ArrayList<>();
            list.add(new Compartoresss(3, "Aman" , 96748851, 88.0, "IT" , 23000.09));
            list.add(new Compartoresss(1, "Pathan", 7776655, 55, "Java" , 19000.09));
            list.add(new Compartoresss(2, "Rahul", 8787666, 90, "IT" , 29000.56));
        list.add(new Compartoresss(3, "Jurry" , 95678993, 56, "HR" , 80000.009));
        list.add(new Compartoresss(1, "Pathan", 90909090, 56, "Manager" , 19000.56));
        list.add(new Compartoresss(2, "Rahul", 6787666, 90, "IT" , 800001.00));
            // by  name(filter)
      Comparator<Compartoresss>  byName=(s1,s2) ->s1.name.compareTo(s2.name);
         // by id(filter)
       Comparator<Compartoresss> byId =(s3,s4)-> Integer.compare(s4.id , s3.id);

       // filter whos salary is more then 80000 and department is IT print them only
     Stream<Compartoresss> results= list.stream()
                .filter(r->
                {
                    if (r.salary != null && !r.department.isEmpty()) {
                        return r.salary > 80000 && r.department.equalsIgnoreCase("IT");
                }
                else {
                        return  false ;
                    }
                });


       List<Compartoresss> list1=new ArrayList<>();
        Collections.sort(list,byName); // by name
        for( Compartoresss s: list){
            list1.add(s);

        }
        List<Compartoresss> list2=new ArrayList<>();
        Collections.sort(list,byId); // by id
        for( Compartoresss s: list){
         list2.add(s);}
        return "filter byName (Ascending order by name only ) -> " +results.collect(Collectors.toList())
                +" (Desceniding Order by id only)" ;

    }


}
