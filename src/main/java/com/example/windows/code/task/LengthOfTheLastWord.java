package com.example.windows.code.task;

public class LengthOfTheLastWord {



    public String LengthOfTheLastWords(){

        String str="  h e ll o worldddd  ";

      str = str.trim();

      int lastSpace=str.lastIndexOf(" "); // last main space melega

        // Substring le lo last space ke baad se end tak
        String lastWord = str.substring(lastSpace + 1);

        return "return -> " + "the length" +lastWord.length() +"and the world "+lastWord;
    }


    public String skip2(){

       int arrp[]={1,2,2,2,4,4,7,8,8,10,8,8,0,100,100,100,100};

        for(int k=2;k<arrp.length;k++){
            // print the result
            System.out.println("arrp" +arrp[k]); // outptu must be 1,2,2,4,4,7,8,8,10,0
        }

        return "outptu is sent" ;
    }


    public String stringFormat(){
        String name="shahruk";
        int age=28;

       String x= String.format("hello %s and your age is %d", name, age);

return  x;
    }

}
