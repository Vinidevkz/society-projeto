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

import com.projeto.teste.entities.Comment;
import com.projeto.teste.services.CommentService;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/comment")
public class CommentResource {

	@Autowired
	private CommentService commentService;
	
	@GetMapping
	public ResponseEntity<List<Comment>> findAll(){
		List<Comment> comments = commentService.findAll();
		return ResponseEntity.ok().body(comments);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Comment> findById(@PathVariable Long id){

			Comment comment = commentService.findById(id);
			return ResponseEntity.ok().body(comment);
		
	}
	
	@PostMapping
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
		comment = commentService.createComment(comment);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
		
		return ResponseEntity.created(uri).body(comment);
	}
}