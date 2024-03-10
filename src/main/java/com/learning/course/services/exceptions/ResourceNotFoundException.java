package com.learning.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Integer id) {
		
		super("Resource not found. id " + id);
		
	}

}
