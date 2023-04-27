package com.myTinyLibrary.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.myTinyLibrary"})
@MapperScan(basePackages = {"com.myTinyLibrary.**.mapper"})
public class MyTinyLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTinyLibraryApplication.class, args);
	}

}
