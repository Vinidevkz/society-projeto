package com.projeto.teste.dto;

import java.util.HashSet;
import java.util.Set;

import com.projeto.teste.entities.Post;


public class UserDTO {
	private Long id;
	private String name;
	private String description;
	private String email;
	private String password;
	private Set<Post> posts = new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
