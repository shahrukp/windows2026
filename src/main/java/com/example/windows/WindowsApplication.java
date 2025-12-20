package com.example.windows;

import com.example.windows.code.task.GapCalulation;
import com.example.windows.controller.StreamAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.example.windows.springboot.annotation_2026")
public class WindowsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindowsApplication.class, args);
	ClassLoader classLoader=WindowsApplication.class.getClassLoader();


//		GapCalulation gapCalulation =new GapCalulation();
//		gapCalulation.GapCalculation("shahruk pathan", "shahruk pathan");

	System.out.println("class_loader  () -->"+classLoader);

		StreamAPI objRef=new StreamAPI();

		System.out.println("reveser the string " +objRef.reveserString());
		System.out.println("toUpperCase  " + StreamAPI.toupperCase());

		System.out.println("toUpperCase  " + StreamAPI.	firstNonRepatingChar());
		objRef.EachOccurence();
		objRef.EachOccurenceList();

		System.out.println("Run..!");
		// check class loader

	}



}
