package com.example.windows.oopps;

import java.io.Serializable;

public class Serilizaable  implements Serializable {

    //important note ; > the instance of this class called/save in locaton ->  master.controlere JavAllinCodedemo

    String name ;
    double  bankCode ; // secret code
   private transient static double  amount ; // transitent has no impact due to static


    public  Serilizaable(){

    }

    public  Serilizaable( String name ,double  bankCode,double  amount){
        this.name=name;
        this.amount=amount;
        this.bankCode=bankCode;

    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double bankCode() {
        return bankCode;
    }

    public void setBankCode(double bankCode) {
        this.bankCode = bankCode;
    }

    public static double amount() {
        return amount;
    }

    public static void setAmount(double amount) {
        Serilizaable.amount = amount;
    }
}
