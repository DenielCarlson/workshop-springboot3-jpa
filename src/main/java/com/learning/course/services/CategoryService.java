package com.learning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.course.entities.Category;
import com.learning.course.repositories.CategoryRespository;

@Service
public class CategoryService{
	
	@Autowired
	private CategoryRespository categoryRespositoty;
	
	public List<Category> findAll(){
		
		List<Category> categories = categoryRespositoty.findAll();
		
		return categories;
		
	}
	
	public Optional<Category> findById(Integer id){
		
		Optional<Category> category = categoryRespositoty.findById(id);
		
		return category;
		
	}

}
