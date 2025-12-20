package com.example.windows.collection_Lambda_2025;

import org.springframework.stereotype.Component;

@FunctionalInterface
interface  Fun{

    public abstract  int addpoints(int x,int y);
}

@Component
public class Lmabda2 {

    public String lambda2(){

        Fun f= (int c,int g)->{
            return c+g;
        };

        return "points are -> "  +f.addpoints(112,123);

    }
}
