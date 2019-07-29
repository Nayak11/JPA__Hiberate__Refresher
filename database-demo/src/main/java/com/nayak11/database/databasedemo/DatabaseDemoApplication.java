package com.nayak11.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nayak11.database.databasedemo.jdbc.PersonJdbcDao;

/*
 * Spring JDBC advantage over JDBC
 * - Less amount of code
 * - prevents us from making mistake, because we don't need to take care of connection or closing of connection even when exception occurs. 
 * */

/*
 * We want the query mentioned in PersonJdbcDao at the start-up of the app. To implement this we will implement CommandLineRunner which will make the
 * code written inside run method will be launched up when the app context is ready
 * */
@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{

	//print values to the console(What is the difference between SOP()) <-------------------------------- ? ? ? ? ?
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}"+dao.findAll());
		logger.info("User ID 10001 -> {}"+dao.findByID(10001));
		logger.info("User from Udupi -> {}"+dao.findByLocation("Udupi"));
	}

}
