package com.example.windows.code.task;

public class SwapVariables {



    public String swapVariables(){

        int x=14;
        int y= 20;

        System.out.println("original value's x  " +x +"and the y"  +y);
          x=x+y; // 14 , 20 =34   x =34 current value

          y= x-y; // 34-20 14
         x= x-y;   // x 34 -14 = 20
         System.out.println("after swap the numbers  x is " +x +"and the y is " +y);



        return "swap done !";
    }
}
