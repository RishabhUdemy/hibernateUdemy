package com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
public class Course {
	@Getter
	@Setter
	@Id
	private int courseId;
	
	@Getter
	@Setter
	@NonNull
	private String name;
}
