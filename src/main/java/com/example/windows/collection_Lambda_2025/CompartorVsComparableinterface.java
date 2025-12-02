package com.example.windows.collection_Lambda_2025;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CompartorVsComparableinterface {

    public String comparableDemo() {
  List<EmployeObj> result=Arrays.asList(new EmployeObj("shahruk", "SoftwaerEngineer",
                        25000.00, "2059001", "Associate Consulatant"),

                new EmployeObj("tom", "SoftwaerEngineer",
                        18000.00, "2028484", "Python"),

                new EmployeObj("Jerry", "Manager",
                        12300.00, "2059004", "Co-Manager"),

          new EmployeObj("Meery", "Manager",
                  500.00, "2059004", "Manager"),

                new EmployeObj("Tilu", "HR",
                        17020.00, "2059009", "Senior-HR"));
System.out.println("inside comparableDemo ? ");
// sort by id print records  min salary to max

        Collections.sort(result);

        // print who salary has between 10k t0 25k using streeam api
        Double min=10000.00;
        Double max=25000.00;
  List<EmployeObj> output=result.stream()
                .filter(Objects::nonNull)
              //  .filter(e->e.salary() > 10000 && e.salary() < max )
            .filter(e->e.salary() <=1000.00)
                .collect(Collectors.toList());


        // group by    department on manager
   Map<Object, List<EmployeObj>> output1= result.stream()
           .filter(e-> !e.department(). isEmpty() && e.department().equalsIgnoreCase("Manager"))
                .collect(Collectors.groupingBy(
                        EmployeObj::department,
                        Collectors.toList()));

        return "result -> " +output1;
    }








    public String comparatorDemo() {


        return null;
    }


}
