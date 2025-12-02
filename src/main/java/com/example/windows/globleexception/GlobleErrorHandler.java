package com.example.windows.globleexception;


import com.example.windows.custommessage.NameAlreadyExxitException;
import com.example.windows.employee.impl.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobleErrorHandler {

    // for single records
    @ExceptionHandler(NameAlreadyExxitException.class)
    public ResponseEntity<ApiResponse> nameAlreadyExits(HttpServletRequest hthpServletRequest , NameAlreadyExxitException nameAlreadyExxitException){
        ApiResponse apiResponse=new ApiResponse(

                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                        nameAlreadyExxitException.getMessage(),
                        hthpServletRequest.getRequestURI());


        //return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(apiResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }
    // for multiple records
    @ExceptionHandler(MultipleRecordFailedToUpload.class)
    public ResponseEntity<ApiResponse> multipleRecordsError(HttpServletRequest hthpServletRequest , NameAlreadyExxitException nameAlreadyExxitException){
        ApiResponse apiResponse=new ApiResponse(

                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                nameAlreadyExxitException.getMessage(),
                hthpServletRequest.getRequestURI());


        //return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(apiResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }



}
