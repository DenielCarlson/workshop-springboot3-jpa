package com.learning.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learning.course.entities.Order;
import com.learning.course.entities.User;
import com.learning.course.entities.enums.OrderStatus;
import com.learning.course.repositories.OrderRespository;
import com.learning.course.repositories.UserRespository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRespository userRepository;
	
	@Autowired
	private OrderRespository orderRespository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Marcos", "marcos@gmail.com", "31 9 1234-5678", "12345");
		User u2 = new User(null, "Amanda", "amanda@gmail.com", "11 9 1234-5678", "54321");
		
		Order o1 = new Order(null, Instant.parse("2024-03-05T19:20:12-03:00"), OrderStatus.WAINTING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2020-04-20T08:25:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2021-06-20T10:56:20Z"), OrderStatus.PAID, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRespository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
}
