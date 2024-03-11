package com.learning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.course.entities.Product;
import com.learning.course.repositories.ProductRepository;
import com.learning.course.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		
		List<Product> products = productRepository.findAll();
		
		return products;
	}
	
	public Product findById(Integer id){
		
		Optional<Product> product = productRepository.findById(id);
		
		return product.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
}
