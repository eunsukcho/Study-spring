package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import com.example.mongo.bean.MongoBean;
import com.example.mongo.persistance.FileDetailDAO;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.example.mongo")
public class BookBoardApplication {

	@Autowired
	private MongoBean mongobean;
	
	@Autowired
	private static FileDetailDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(BookBoardApplication.class, args);

	}
	
}
