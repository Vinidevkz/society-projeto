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

import com.projeto.teste.entities.Post;
import com.projeto.teste.services.PostService;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/post")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> posts = postService.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable Long id){
			Post post = postService.findById(id);
			return ResponseEntity.ok().body(post);
	}
	
	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody Post post){
		post = postService.createPost(post);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(uri).body(post);
	}
}
