package com.projeto.teste.resources;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.teste.entities.CommentLike;
import com.projeto.teste.services.CommentLikeService;
import com.projeto.teste.services.CommentLikeService;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/commentLikeLike")
public class CommentLikeResource {

	@Autowired
	private CommentLikeService commentLikeService;
	
	@GetMapping
	public ResponseEntity<List<CommentLike>> findAll(){
		List<CommentLike> commentLikes = commentLikeService.findAll();
		return ResponseEntity.ok().body(commentLikes);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CommentLike> findById(@PathVariable Long id){

			CommentLike commentLike = commentLikeService.findById(id);
			return ResponseEntity.ok().body(commentLike);
		
	}
	
	@PostMapping
	public ResponseEntity<CommentLike> createCommentLike(@RequestBody CommentLike commentLike){
		commentLike = commentLikeService.createCommentLike(commentLike);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(commentLike.getId()).toUri();
		
		return ResponseEntity.created(uri).body(commentLike);
	}
}