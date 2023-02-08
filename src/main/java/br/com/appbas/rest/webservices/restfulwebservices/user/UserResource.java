package br.com.appbas.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoSercice service;
	
	public UserResource(final UserDaoSercice service) {
		this.service = service; 
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable final int id) {
		return Optional.ofNullable(service.findOne(id)).orElseThrow(() ->
			 new UserNotFoundException("id: " + id)
		);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		service.save(user);
		
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable final int id) {
		service.deleteById(id);
	}

}
