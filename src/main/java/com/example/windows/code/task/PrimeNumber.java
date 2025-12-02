package com.example.windows.code.task;

public class PrimeNumber {


    public String primeNumber(){
     // 0 and 1 is not a prime number
        int number = 7;  // you can test other numbers too

        // 0 and 1 are not prime numbers
        if (number < 2) {
            return "Not a prime number";
        }
        // check divisibility from 2 to sqrt(number)
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "Not a prime number";
            }
        }
        return "Yes, prime number";
    }
}
