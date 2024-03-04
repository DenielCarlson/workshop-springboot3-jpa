package com.learning.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learning.course.entities.User;
import com.learning.course.repositories.UserRespository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRespository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Marcos", "marcos@gmail.com", "31 9 1234-5678", "12345");
		User u2 = new User(null, "Amanda", "amanda@gmail.com", "11 9 1234-5678", "54321");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
