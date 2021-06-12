package com.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "find_all_person",query = "select p from Person p")
public class Person {

	
	@Id
	private int id;
	private String name;
	private String address;
	private double salary;
	private Date dateofbirth;
}
