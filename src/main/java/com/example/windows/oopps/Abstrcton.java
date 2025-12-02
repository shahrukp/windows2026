package com.example.windows.oopps;

class Vv extends  Abstrcton{


    /**
     * @return
     */
    @Override
    public int docaluculate() {
        return 0;
    }
}
class V extends  Abstrcton{


    /**
     * @return
     */
    @Override
    public int docaluculate() {
        return 0;
    }
}

abstract class Abstrcton {


   // public   int docaluculate(); //abstract  method howeevr this is not valid due need retrun keyword

    public abstract   int docaluculate(); //this is valid now

    public  Abstrcton(){
        System.out.println("yes im  support here ");

    }

    protected  int num; // allowed
    private int age=22; //  vrianle final static non static

       static void  dp(){  // can be private proteded or public  not default ?

        System.out.println("Hi ");
    }
}
