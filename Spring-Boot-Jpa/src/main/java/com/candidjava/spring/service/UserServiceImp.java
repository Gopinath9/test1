package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.repository.UserRepository;

@Service

public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;
	@Transactional
	public int createUser(User user) {
		int statusCode = 200;
		List<User> users = userRepository.findByName(user.getName());
		if(users != null && !users.isEmpty()) {
			statusCode = 409;
		} else {
			userRepository.save(user);
		}
		return statusCode;
	}
	@Transactional
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public User update(User user, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	public User updatePartially(User user, long id) {
		// TODO Auto-generated method stub
		User usr = findById(id);
		usr.setCountry(user.getCountry());
		return userRepository.save(usr);
	}



}
