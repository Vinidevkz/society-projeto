package com.projeto.teste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.teste.dto.UserDTO;
import com.projeto.teste.entities.User;
import com.projeto.teste.services.UserService;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		user = userService.createUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
		User newUser = new User(id, userDTO.getName(), userDTO.getDescription(), userDTO.getEmail(), userDTO.getPassword());
		User updatedUser = userService.updateUser(id, newUser);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		try {
			userService.deleteUser(id);
			return ResponseEntity.ok("Usuario deletado com sucesso.");
		}catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id) ;
		}
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){

			User user = userService.findById(id);
			return ResponseEntity.ok().body(user);
		
	}
	

}