package com.yicai.taotalent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class TaotalentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaotalentApplication.class, args);
	}
}
