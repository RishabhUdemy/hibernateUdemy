package com.jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.dao.PersonRepo;
import com.jpa.entity.Person;

@SpringBootApplication
public class Udemy02JpaHibernateApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Udemy02JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("===========");
		logger.info("Insert Person");
		logger.info(""+repo.insertPerson(new Person(1001, "John", "Friends", 782254.2, new Date() )));
		logger.info(""+repo.insertPerson(new Person(1002, "Smith", "Hyderabad", 89254.2, new Date() )));
		logger.info(""+repo.insertPerson(new Person(1003, "Mike", "California", 889254.89, new Date() )));
		
		logger.info(""+repo.findById(1001));
		
		logger.info("delete the person");
		
		repo.deleteById(1001);
		
		repo.findAll().forEach(System.out::println);
		
		
		
	}

}
