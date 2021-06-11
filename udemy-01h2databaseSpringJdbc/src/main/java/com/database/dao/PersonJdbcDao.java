package com.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.database.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String PERSON_QUERY = "SELECT * FROM PERSON";
	private final String PERSON_ID = "SELECT * FROM PERSON WHERE id = ?";
	private final String PERSON_DELETE = "DELETE FROM PERSON WHERE id = ?";
	private final String PERSON_INSERT = "INSERT INTO PERSON (id,name,address,dateofbirth) values(?,?,?,?)";
	private final String PERSON_UPDATE = "UPDATE PERSON SET name = ?,address = ?,dateofbirth=? where id = ?";
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setAddress(rs.getString("address"));
			person.setDateofbirth(rs.getTimestamp("dateofbirth"));
			return person;
		}
		
	}
	
	public List<Person> getListOfPerson() {
		//return jdbcTemplate.query(PERSON_QUERY, new BeanPropertyRowMapper<Person>(Person.class));
		return jdbcTemplate.query(PERSON_QUERY, new PersonRowMapper());
	}
	
	public Person getFindById(Integer id) {		
		//return jdbcTemplate.queryForObject(PERSON_ID, new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
		return jdbcTemplate.queryForObject(PERSON_ID, new Object[] {id}, new PersonRowMapper());
	}
	
	public int deleteById(Integer id) {
		return jdbcTemplate.update(PERSON_DELETE,new Object[] {id});
	}
	
	public int insertIntoPerson(Person person) {
		return jdbcTemplate.update(PERSON_INSERT,new Object[] {person.getId(),person.getName(),person.getAddress(),new Timestamp(person.getDateofbirth().getTime())});
	}
	
	public int updatePerson(Person person) {
		return jdbcTemplate.update(PERSON_UPDATE, new Object[] {person.getName(),person.getAddress(),person.getDateofbirth(),person.getId()});
	}
}
