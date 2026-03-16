package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.teste.entities.Comment;
import com.projeto.teste.entities.Comment;
import com.projeto.teste.repository.CommentRepository;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public void deleteComment(Long id) {
		
	}
	
	public List<Comment> findAll(){
		return commentRepository.findAll();
	}
	
	public Comment findById(Long id) {
		Optional<Comment> comment = commentRepository.findById(id);
	    return comment.orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
