package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.teste.entities.Post;
import com.projeto.teste.entities.User;
import com.projeto.teste.repository.UserRepository;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(Long id, User newUser) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		updateData(user, newUser);
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
	    return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//
	 public void updateData(User existingUser, User newUser) {
		 existingUser.setName(newUser.getName());
		 existingUser.setDescription(newUser.getDescription());
		 existingUser.setEmail(newUser.getEmail());
		 existingUser.setPassword(newUser.getPassword());
		 
	 }
}
