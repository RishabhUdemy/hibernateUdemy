package com.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.dao.CourseDAO;
import com.jpa.entity.Course;

@SpringBootTest(classes = Udemy03JpaHibernateEntityManagerApplication.class)
class Udemy03JpaHibernateEntityManagerApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseDAO dao;
	
	@Test
	void contextLoads() {
		logger.debug("Entering into Test class");
		
		Course course1 =  dao.getCourseDetail(1001);
		assertEquals("JPA hibernate", course1.getName());
	}

}
