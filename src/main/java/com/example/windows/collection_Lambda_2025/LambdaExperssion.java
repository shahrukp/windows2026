package com.example.windows.collection_Lambda_2025;

import org.springframework.stereotype.Component;

@FunctionalInterface //noneedbutstillgood
interface A{
    public int doCalculation(int x,int y);
}
@Component
public class LambdaExperssion {
    public int usingAnnymousFunction(){
        A aa=new A(){
            @Override
            public int doCalculation(int x, int y) {

                return x-y;}
        };
        return aa.doCalculation(100,120);
    }
    public int  doLambdaWork(){
        A a = (int x, int y) ->{
            System.out.println("lambda_Experssion");
            return  x+y;
        };
        return  a.doCalculation(10,90);
    }

    public String sayMessage(){

        return "String is Working!";
    } //Mathiyalagan



}
