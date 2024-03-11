package com.learning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.learning.course.entities.User;
import com.learning.course.repositories.UserRespository;
import com.learning.course.services.exceptions.DataBaseException;
import com.learning.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRespository userRepository;
	
	public List<User> findAll(){
		
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User findById(Integer id){
		
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public User insert(User user) {
		
		return userRepository.save(user);
	}
	
	public void delete(Integer id) {
		
		try {
			if(!userRepository.existsById(id)) throw new ResourceNotFoundException(id);
			userRepository.deleteById(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Integer id, User user) {
		
		try {
			User entity = userRepository.getReferenceById(id);
			
			updateEntity(entity, user);
			
			return userRepository.save(entity);
			
		}
		catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateEntity(User entity, User user) {
		
		if(user.getName() != null) entity.setName(user.getName());
		if(user.getEmail() != null) entity.setEmail(user.getEmail());
		if(user.getPhone() != null) entity.setPhone(user.getPhone());
	}
}
