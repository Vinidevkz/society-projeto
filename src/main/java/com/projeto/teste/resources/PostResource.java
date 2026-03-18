package com.projeto.teste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.teste.dto.PostDTO;
import com.projeto.teste.entities.Post;
import com.projeto.teste.entities.User;
import com.projeto.teste.services.PostService;
import com.projeto.teste.services.UserService;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/post")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO){
		try {
			Post post = new Post();
			
			post.setTitle(postDTO.getTitle());
			post.setDescription(postDTO.getDescription());
			post.setImgURL(postDTO.getImgURL());
			
			User user = new User();
			user.setId(postDTO.getUser_id());
			post.setUser(user);
			
			post = postService.createPost(post);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
			
			return ResponseEntity.created(uri).body(post);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO){
		User user = userService.findById(postDTO.getUser_id());
		Post post = new Post(null, postDTO.getTitle(), postDTO.getDescription(), user);
		Post updatedPost = postService.updatePost(id, post);
		return ResponseEntity.ok(updatedPost);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> posts = postService.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable Long id){
		try {
			Post post = postService.findById(id);
			return ResponseEntity.ok().body(post);	
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}
}
