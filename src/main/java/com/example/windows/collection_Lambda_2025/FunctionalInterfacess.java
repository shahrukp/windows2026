package com.example.windows.collection_Lambda_2025;


import org.springframework.stereotype.Component;

// functional Interface
@FunctionalInterface   //--->optional
interface  FunInterface {
    public int phoneNumber();  // abstrct method
    //contain n number of static  and defaultmethod
    // static
     static String saySomeMessage(){
        return "Hi,there, im static method  ";
    }
    // default
    default String sayCode(int a,int b){
        return "Hi,there default code is -> " +a+b;
    }
}
@Component
public class FunctionalInterfacess {
    //call using annymous function

    public String fecthNumber() {
        //annymous function
        FunInterface funInterface = new FunInterface() {
            /**
             * @return
             */
            @Override
            public int phoneNumber() {
                return 9673885;
            }
        };// call static and default method
        // static
      String x=FunInterface.saySomeMessage();
      // default
     // funInterface.sayCode(12,83);
        return "phone number -> " +funInterface.phoneNumber()
        +"static method ->" +x
        +"default method -> "+funInterface.sayCode(12,83);
    }

}
