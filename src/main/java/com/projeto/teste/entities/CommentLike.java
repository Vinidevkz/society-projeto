package com.projeto.teste.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_commentLikes")
public class CommentLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "comment_id")
	@JsonBackReference
	private Comment comment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user_id;
	
	public CommentLike() {
		
	}
	
	public CommentLike(Long id, Comment comment, User user) {
		super();
		this.id = id;
		this.comment = comment;
		this.user_id = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	public Long getUser_id() {
		return this.user_id.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentLike other = (CommentLike) obj;
		return Objects.equals(id, other.id);
	}
	
	


}
