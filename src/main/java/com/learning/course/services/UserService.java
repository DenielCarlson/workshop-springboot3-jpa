package com.learning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.course.entities.User;
import com.learning.course.repositories.UserRespository;

@Service
public class UserService {

	@Autowired
	private UserRespository userRepository;
	
	public List<User> findAll(){
		
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public Optional<User> findById(Integer id){
		
		Optional<User> user = userRepository.findById(id);
		
		return user;
		
	}
	
	public User insert(User user) {
		
		return userRepository.save(user);
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
}
