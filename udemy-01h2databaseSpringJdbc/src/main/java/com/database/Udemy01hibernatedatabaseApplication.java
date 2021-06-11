package com.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.database.dao.PersonJdbcDao;
import com.database.entity.Person;

@SpringBootApplication
public class Udemy01hibernatedatabaseApplication implements CommandLineRunner{

	@Autowired
	PersonJdbcDao personDao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	public static void main(String[] args) {
		SpringApplication.run(Udemy01hibernatedatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person detail {} \n"+personDao.getListOfPerson()+" \n");
		
		logger.info("Person find by id \n"+personDao.getFindById(1001)+"\n");
		
		logger.info("Delete person by id \n"+personDao.deleteById(1002)+"\n");
		
		logger.info("Person detail {} \n"+personDao.getListOfPerson()+" \n");
		
		logger.info("Insert Person in DB "+personDao.insertIntoPerson(new Person(1005, "JOEY", "US", new Date())));
		
		logger.info("Person detail {} \n"+personDao.getListOfPerson()+" \n");
		
		logger.info("Update Person "+personDao.updatePerson(new Person(1003,"RISHABH","INDIA",new Date())));
	
		logger.info("Person detail {} \n"+personDao.getListOfPerson()+" \n");
	}

}
