package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.teste.entities.CommentLike;
import com.projeto.teste.entities.CommentLike;
import com.projeto.teste.repository.CommentLikeRepository;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@Service
public class CommentLikeService {

	@Autowired
	private CommentLikeRepository commentLikeRepository;
	
	public CommentLike createCommentLike(CommentLike commentLike) {
		return commentLikeRepository.save(commentLike);
	}
	
	public void deleteCommentLike(Long id) {
		
	}
	
	public List<CommentLike> findAll(){
		return commentLikeRepository.findAll();
	}
	
	public CommentLike findById(Long id) {
		Optional<CommentLike> commentLike = commentLikeRepository.findById(id);
	    return commentLike.orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
