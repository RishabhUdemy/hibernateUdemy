package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Person;

@Repository
@Transactional

public class PersonRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person insertPerson(Person person) {
		return entityManager.merge(person);
	}
	
	public Person updatePerson(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll(){
		TypedQuery<Person> query =  entityManager.createNamedQuery("find_all_person",Person.class);
		return query.getResultList();
	}
}
