package com.example.windows.code.task;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ConsumerFunction {



    // void  // accept
    public String consumerFunction(){


        Consumer<Integer> numbers=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
            }
        };
        Consumer<String> printName = name -> System.out.println("Employee Name: " + name);
        printName.accept("Pathan");
        AtomicInteger salary= new AtomicInteger(1000);
        Consumer<Integer> increaseSalary = e -> salary.addAndGet(e);
        increaseSalary.accept(2000);

// Output: Employee Name: Pathan
return null;

    }

}
