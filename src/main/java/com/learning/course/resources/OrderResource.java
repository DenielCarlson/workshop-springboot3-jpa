package com.learning.course.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.course.entities.Order;
import com.learning.course.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> orders = orderService.findAll();
		
		return ResponseEntity.ok().body(orders);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Optional<Order>> findById(@PathVariable Integer id){
	
		Optional<Order> order = orderService.findById(id);
		
		return ResponseEntity.ok().body(order);
	}

}
