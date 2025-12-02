package com.example.windows.employee.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code/task/dummy/")
public class DummyControllerForCodeTask {


// localhost//8080/code/task/dummy/check?inputTyep=pass_user_type
    @GetMapping("check")
    public ResponseEntity<?> checkPalindromeDigitAndString(@
                                                                       RequestParam String inputTyep) {
        String forStringCode = "str";

//        if (inputType.equalsIgnoreCase("str")) {
//            return ResponseEntity.ok(isPalindrome(value) ? "palindrome" : "not palindrome");
//        } else {
//            return ResponseEntity.ok(isPalindrome(value) ?
//                    "palindrome int value " + value : "not palindrome int value " + value);
//        }

        if (inputTyep.equalsIgnoreCase(forStringCode)) {
            String str="ASA"; //check palinddrom or not
            String result="";

           char chr[]= str.toCharArray();
           for(int i=chr.length-1;i>=0;i--){
               result+=str.charAt(i);
           }
           String outpu=(str.equalsIgnoreCase(result))?"palindrom" :"not palindrom";
            return new ResponseEntity(outpu, HttpStatus.ACCEPTED);
        }
        if (!inputTyep.equalsIgnoreCase(forStringCode)) {
            int number =123; //check give number is palindrom or not
           String result="";
            // convert into stirng
           String s=String.valueOf(number);
            char chr[]= s.toCharArray();
            for(int i=chr.length-1;i>=0;i--){
                result+=s.charAt(i);
            }
            // comvert back into int
           int backInt=Integer.parseInt(s);

            String outpuInt=(number==backInt)?"palindrom int value " +backInt
                    :"not palindrom int value"  +backInt;
            return new ResponseEntity(outpuInt, HttpStatus.ACCEPTED);

        }
        return new ResponseEntity(" wrong !", HttpStatus.ACCEPTED);

    }
}
