package com.jpa.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Course;

@Repository
@Transactional
public class CourseDAO {

	@Autowired
	EntityManager em;
	
	public Course getCourseDetail(int id) {
		return em.find(Course.class, id);
	}
	
	public Course insertCourse(Course course) {
		return em.merge(course);
	}
}
