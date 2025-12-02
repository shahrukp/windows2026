package com.example.windows.comparablevscampartor;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeCompartorList {


    @Test
    public  void EmployeeCompartorList(){

        List<EmployeeCompartor> e=Arrays.asList(
                new EmployeeCompartor("Shahruk" ,5609.00,"HR" ,"male"),
                new EmployeeCompartor("Sruy" ,5609.00,"HR","female"),
                new EmployeeCompartor("PAthan" ,90000.00,"HR","male"),
                new EmployeeCompartor("Tom" ,19000.00,"TL", "female"),
                new EmployeeCompartor("Z" ,19000.00,"TL" ,"male"),
                new EmployeeCompartor("Jerry" ,2300.90,"Co" , "tarsgender"),
                new EmployeeCompartor("Tomy" ,44000.00,"Owner","female"),
                new EmployeeCompartor("C" ,30000.00,"Owner","male"),
                new EmployeeCompartor("A" ,3109.00,"Employee" , "female"),
                new EmployeeCompartor("S.Pathan" ,12344.33,"Employee","male"));


        // below 12000 salary fecth all employe records
         int targetTreeshood=12000; //targetThreshold
      List<EmployeeCompartor> reult= e.stream()
                .filter(sal->sal.salary() <=targetTreeshood)
                .collect(Collectors.toList());

     // check if no one has salary like below 12000 and equals 12000
       boolean hasExact12000= e.stream().anyMatch(sa->sa.salary()==12000);

       if(!hasExact12000){
           System.out.println("Employee not available with 12000 salary");
       }

      //
       if(!reult.isEmpty()){
           System.out.println("below 12000");
           reult.forEach(System.out::println);
       }

        // dpertment is HR and male all name list desecnding order
         final String targetDep="hr";
        String targetGen="male";
      Map<String, List<EmployeeCompartor>> result=e.stream()
              .filter(obj->obj.departmet() .equalsIgnoreCase(targetDep)
                        && obj.gender().equalsIgnoreCase(targetGen))
                .sorted(Comparator.comparing(EmployeeCompartor::salary).reversed())
                .collect(Collectors.groupingBy(EmployeeCompartor::departmet));


       if(result.isEmpty()){
            System.out.println("list is empty !");
        }else{
           result.forEach((dep, values) ->System.out.println(dep +" and -> " + values));
        }
        System.out.println("-------------------------one-----------------------------------------------" );


        // find max and min salary via old and stream apis
       // using old
        // min
    List<EmployeeCompartor> s=   e.stream()
            .filter(e1->e1.salary() !=null)
                .min(Comparator.comparing(EmployeeCompartor::salary))
            //.sorted(Comparator.comparing(Employee::getSalary))


           // .min((emp1, emp2) -> emp1.salary().compareTo(emp2.salary()));

            .stream().collect(Collectors.toList());
      s.forEach(System.out::println);

       // Get all employees with the minimum salary:
//        Optional<Double> minSalary = e.stream()
//                .filter(e1 -> e1.salary() != null)
//                .map(EmployeeComparator::salary)
//                .min(Double::compareTo);
//
//        List<EmployeeComparator> result = e.stream()
//                .filter(e1 -> e1.salary() != null && minSalary.isPresent() && e1.salary().equals(minSalary.get()))
//                .collect(Collectors.toList());
       // result.forEach(System.out::println);


        System.out.println("------------------------------------------------------------------------" );

        for(EmployeeCompartor ee:e){
            // sort by
            System.out.println(" before sort --> "  +ee);

        }

        System.out.println("------------------------------------------------------------------------" );


        Collections.sort(e ,(a,b) ->a.salary().compareTo(b.salary())); // salary asending order

        for(EmployeeCompartor ee:e){
            // sort by
            System.out.println(" via custome a, b sort --> "  +ee);

        }
        System.out.println("------------------------------------------------------------------------" );

        // Collections.sort(e);

//        Arrays.sort(employees, Comparator.comparing((EmployeeCompartor e) -> e.designation)
//                .thenComparingDouble(e -> e.salary));



       // sort via compartorn inteface

        Collections.sort(e,new EmployeeCompartorInterface()); // done works
//Conditions to work correctly:
       // e is an array of Employee (or whatever your class is called):
       // will not work in this case, because e is a List, not an array.
        //Employee[] e = new Employee[]{...};
       // Arrays.sort(e,new EmployeeCompartorInterface());


        for(EmployeeCompartor ee:e){
            // sort by
            System.out.println(" after sort via compartor operator  --> "  +ee);

        }

        //Collections.sort(List<T> list, Comparator<? super T> c);
       // Collections.sort(e, Comparator.comparing(EmployeeCompartor::name));// ascending order !


        System.out.println("------------------------------------------------------------------------" );
        Collections.sort(e, Comparator.comparing(EmployeeCompartor::name).reversed());

        for(EmployeeCompartor ee:e){
            // sort by
            System.out.println(" after sort --> "  +ee);

        }

    }
}
