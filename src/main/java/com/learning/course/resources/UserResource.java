package com.learning.course.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.course.entities.User;
import com.learning.course.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> users = userService.findAll();

		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Integer id){
		
		Optional<User> user = userService.findById(id);
		
		return ResponseEntity.ok().body(user);
		
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		
		User user = userService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri(); 
			
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		userService.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}
}
