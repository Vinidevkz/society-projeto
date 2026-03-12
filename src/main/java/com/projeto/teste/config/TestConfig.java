package com.projeto.teste.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.teste.entities.User;
import com.projeto.teste.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User(null, "Vinicius", "Biografia do Vinicius - Estudante da Fatec ZL", "vini@gmail.com", "vini123" );
		
		userRepository.save(user);
		
	}
	
}
