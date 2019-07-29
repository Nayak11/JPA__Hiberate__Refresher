package com.nayak11.database.databasedemo.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nayak11.database.databasedemo.entity.Person;


//Talks to the database and gets the value
@Repository
public class PersonJdbcDao {
	
	//We want spring to give the database connection to us
	/*
	 * How is is the JdbcTemplate getting auto-wired in ? How is it knowing about the connection to in memory database ? Where is the data source ?
	 * - Spring boot auto config 
	 * */
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//select * from person
	public  List<Person> findAll(){
		/*
		 * When we execute the query, we get result set back and we need to map result set to Person class
		 * When there is a exact column mapping as in this case we don't need to use row mapper, we can use default row mapper provided by spring. 
		 * */
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	
	public Person findByID(int id) {
		
		return jdbcTemplate.queryForObject("select * from person where id= ?", new Object[] {id},
												new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	
	
	
	//There should be a better method, check that <---------------------------------------- ? ? ? ? ?
	public List<Person> findByLocation(String location){
		
		List<Map<String, Object>> persons = jdbcTemplate.queryForList("select * from person where location=?", new Object[] {location});
		
		List<Person> result = new ArrayList<>();
		
		for (Map<String, Object> map : persons) {
			Person p =new Person();
		    for (Map.Entry<String, Object> entry : map.entrySet()) {
		    	if(entry.getKey().equals("ID")) {
		    		p.setId((int) entry.getValue());
		    	}
		    	if(entry.getKey().equals("NAME")) {
		    		p.setName((String) entry.getValue());
		    	}
		    	if(entry.getKey().equals("LOCATION")) {
		    		p.setLocation((String) entry.getValue());
		    	}
		    	if(entry.getKey().equals("BIRTH_DATE")) {
		    		p.setBirthDate((Date) entry.getValue());
		    	}
		    }

		    result.add(p);
		}
		
		return result;
	}

}
