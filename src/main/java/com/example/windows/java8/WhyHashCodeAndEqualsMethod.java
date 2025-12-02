package com.example.windows.java8;

import java.util.Objects;

public class WhyHashCodeAndEqualsMethod {

    private String name;
    private int mobilenumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhyHashCodeAndEqualsMethod that = (WhyHashCodeAndEqualsMethod) o;
        return mobilenumber == that.mobilenumber && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobilenumber);
    }

    public static int checkBoth() {
        WhyHashCodeAndEqualsMethod whyHashCodeAndEqualsMethod =new WhyHashCodeAndEqualsMethod();

        // retunr has code and equlas method
        boolean a=true;


        if(whyHashCodeAndEqualsMethod instanceof  WhyHashCodeAndEqualsMethod){
            return whyHashCodeAndEqualsMethod.hashCode();

        }else {
            return whyHashCodeAndEqualsMethod.hashCode();
        }



}
    public static void main (String args[]){
       // WhyHashCodeAndEqualsMethod
        System.out.println(checkBoth());
    }
}
