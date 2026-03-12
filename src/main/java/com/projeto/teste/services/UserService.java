package com.projeto.teste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.teste.entities.User;
import com.projeto.teste.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		try {
			userRepository.save(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(User user) {
		
	}
}
