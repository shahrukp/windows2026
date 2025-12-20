package com.example.windows.collection_Lambda_2025;

import org.hibernate.boot.model.internal.XMLContext;
import org.springframework.stereotype.Component;


interface  A1{

    // define in interface only ?
    public default  String say(){

        return "i'm default method ";
    }
}

@Component
public class DefaultMethods {

    // allow todefine default  mehtod with default implemtion
    public String X () {
        A1 a = new A1() {
        };
        return  a.say();
    }

}
