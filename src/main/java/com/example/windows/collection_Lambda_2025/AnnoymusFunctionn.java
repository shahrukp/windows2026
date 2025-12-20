package com.example.windows.collection_Lambda_2025;


import org.springframework.stereotype.Component;

@FunctionalInterface
interface   AnnymousFunc {
    //sam
    public String message(String message);
}
@Component
public class AnnoymusFunctionn {

public String callBelowCode() {
    AnnymousFunc a = new AnnymousFunc() {
        /**
         * @param message
         * @return
         */

        @Override
        public String message(String message) {
            return "hey,i'm annyoumus function" +message;
        }
    };

    return  a.message("2026");
}
}
