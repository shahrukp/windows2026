package com.example.windows.oopps;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class TryWithoutcatch {

    // possible yes however required final

    public  static String tryWithoutCatch() {
        // divided by zero
        try {
            int a = 500;
            if (a > 0) {
                int result = a / 10;
                System.out.println("output is " + result);
            }
        } finally {
            System.out.println("Arthimatical exception... " + Exception.class);
        }
        return "output is genrated ! ";

    }
    public static void main (String args[]) {

        tryWithoutCatch();

}
}
