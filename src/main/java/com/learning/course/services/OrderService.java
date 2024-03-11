package com.learning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.course.entities.Order;
import com.learning.course.repositories.OrderRespository;
import com.learning.course.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRespository orderRespository;
	
	public List<Order> findAll(){
		
		List<Order> orders = orderRespository.findAll();
		
		return orders;
	}
	
	public Order findById(Integer id){
		
		Optional<Order> order = orderRespository.findById(id);
		
		return order.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
