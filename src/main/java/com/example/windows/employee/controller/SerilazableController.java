package com.example.windows.employee.controller;

import com.example.windows.oopps.Serilizaable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;

@RestController
@RequestMapping("/apis/")
public class SerilazableController {

    @GetMapping("/get")
    String say(){
        return "WIP ? ";
    }

    //save Serilizable obj
    @PostMapping("/save")
    public ResponseEntity<Serilizaable> saveSerilizaable(){
        try{Serilizaable serilizaable =new Serilizaable(  "shahruk_pathan" ,777.00, 788.0);
            String fileLocation ="E:\\DOWNLOAD_SOFTWARE\\projects\\window\\UseforSeriliazableRecord.txt";

            File file =new File(fileLocation);

            // make sure paent directtory exits
           File parentDir= file.getParentFile();
            if(!parentDir.exists()){
                parentDir.mkdirs();
            }

            if(!file.exists()){
                file.createNewFile();
            }


            System.out.println("file locaton is " +file.getAbsolutePath());
          //  FileWriter fileWriter =new FileWriter(file);
//                fileWriter.write(serilizaable);
//                fileWriter.close();
            // other way to save object
            FileOutputStream fileOutputStream =new FileOutputStream(file);
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serilizaable);
            return  new ResponseEntity("file saved " +file.getAbsolutePath() , HttpStatus.ACCEPTED);

        }catch (FileSystemNotFoundException e){
            return  new ResponseEntity("file not found " +e , HttpStatus.ACCEPTED);
        } catch (IOException e) {
            throw new RuntimeException("something went wrong " +e);
        }

    }



}
