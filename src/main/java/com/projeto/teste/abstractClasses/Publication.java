package com.projeto.teste.abstractClasses;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projeto.teste.entities.Comment;
import com.projeto.teste.entities.PostLike;
import com.projeto.teste.entities.User;
import com.projeto.teste.enums.PostTypes;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

@MappedSuperclass
public abstract class Publication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private PostTypes postType;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUser() {
		return user.getId();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostTypes getPostType() {
		return postType;
	}

	public void setPostType(PostTypes postType) {
		this.postType = postType;
	}
	
	
	
	
	
	
	
}
