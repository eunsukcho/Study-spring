package com.example.mongo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages="com.example.mongo")
public class MongoBean {

	@Bean
	public MongoDbFactory mongoDbFactory(){
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		//UserCredentials userCredentials = new UserCredentials("", "");
		return new SimpleMongoDbFactory(mongoClient, "CrawlBook");
	}
	
	@Bean
	public MongoTemplate mongoTemplata() throws Exception{
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
}
