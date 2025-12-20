package com.example.windows.collection2026;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CallComparble_ComparbleInterfce {


    // compaable only
    public String comparble(){
        ComprableInterface comprableInterface =new ComprableInterface();
        //1
        comprableInterface.setAge(28);
        comprableInterface.setId(1);
        comprableInterface.setPincode(4452077);
        comprableInterface.setUsername("Shahruk_Khan");
        //2
        comprableInterface.setAge(29);
        comprableInterface.setId(4);
        comprableInterface.setPincode(445208);
        comprableInterface.setUsername("Tilu_Khan");
        //3
        comprableInterface.setAge(281);
        comprableInterface.setId(3);
        comprableInterface.setPincode(445207);
        comprableInterface.setUsername("TiluBabuni_Khan");
      //  comprableInterface.compareTo(comprableInterface);

       // comprableInterface.age();

        List<ComprableInterface> list =new ArrayList<>();

        list.add(comprableInterface);



        return  "output is for comparable interface  -> " +list.toString();
    }

    // compaator  only
    public String compartor(){

   List<CompartorInterafce> x= Arrays.asList(new CompartorInterafce(1, 445207, "Shahruk_",27),
                new CompartorInterafce(4, 445208, "Tilu",4),
                new CompartorInterafce(6, 445209, "Sonu",8),
                new CompartorInterafce(8, 445203, "Tom",21),
                new CompartorInterafce(9, 445207, "Jerry",18));

// sort by id
        Comparator<CompartorInterafce> byId=(age1, age2) -> Integer.compare(age1.age(), age2.age());


        return  "output is -> " + x;
    }
}
