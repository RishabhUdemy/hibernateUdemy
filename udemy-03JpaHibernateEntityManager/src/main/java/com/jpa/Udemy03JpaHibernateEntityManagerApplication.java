package com.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.dao.CourseDAO;
import com.jpa.entity.Course;

@SpringBootApplication
public class Udemy03JpaHibernateEntityManagerApplication implements CommandLineRunner{


	@Autowired
	CourseDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(Udemy03JpaHibernateEntityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = new Course();
		course.setCourseId(1001);
		course.setName("JPA hibernate");
		dao.insertCourse(course);
		logger.info("find course");
		logger.info(dao.getCourseDetail(1001)+"");
	}

}
