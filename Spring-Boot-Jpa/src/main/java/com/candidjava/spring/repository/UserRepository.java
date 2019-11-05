package com.candidjava.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.candidjava.spring.bean.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByName(String name);
	
	List<User> findByCountry(String country);
	
	List<User> findById(long id);
	
	List<User> findByNameAndCountry(String name, String country);
	
	List<User> findByNameOrCountry(String name, String country);
	
	List<User> findByNameAndCountryNot(String name, String country);
	
}