package com.learning.course.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.course.entities.Product;
import com.learning.course.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> products = productService.findAll();
		
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Product>> findById(@PathVariable Integer id){
		
		Optional<Product> product = productService.findById(id);
		
		return ResponseEntity.ok().body(product);
		
	}
}
