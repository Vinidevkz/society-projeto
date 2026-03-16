package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import com.projeto.teste.entities.Post;
import com.projeto.teste.repository.PostRepository;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	public void deletePost(Long id) {
		
	}
	 @EntityGraph(attributePaths = {"comments", "comments.commentLikes"})
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(Long id) {
		Optional<Post> post = postRepository.findById(id);
	    return post.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
