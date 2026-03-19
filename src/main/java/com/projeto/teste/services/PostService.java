package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import com.projeto.teste.entities.Post;
import com.projeto.teste.repository.PostRepository;
import com.projeto.teste.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	public Post updatePost(Long id, Post entryPost) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		updateData(post, entryPost);
		return postRepository.save(post);
	}
	
	public void deletePost(Post post) {
		postRepository.delete(post);
	}
	

	public Post findById(Long id) {
		Optional<Post> post = postRepository.findById(id);
	    return post.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@EntityGraph(attributePaths = {"comments", "comments.commentLikes"})
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	////
	 public void updateData(Post existingPost, Post newPost) {
		 existingPost.setDescription(newPost.getDescription());
		 existingPost.setImgURL(newPost.getImgURL());
	 }
}
