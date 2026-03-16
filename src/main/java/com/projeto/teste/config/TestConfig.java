package com.projeto.teste.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.teste.entities.Comment;
import com.projeto.teste.entities.CommentLike;
import com.projeto.teste.entities.Post;
import com.projeto.teste.entities.User;
import com.projeto.teste.repository.CommentLikeRepository;
import com.projeto.teste.repository.CommentRepository;
import com.projeto.teste.repository.PostRepository;
import com.projeto.teste.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private CommentLikeRepository commentLikeRepository;

	
	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Vinicius", "Biografia do Vinicius - Estudante da Fatec ZL", "vini@gmail.com", "vini123" );	
		User user2 = new User(null, "Ana", "Biografia da Ana - Estudante da Etec ZL", "ana@gmail.com", "ana123" );	
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Post post = new Post(null, "Como consegui meu primeiro estágio em TI", "Acesse: www.ciadetalentos.com.br", user1);
		postRepository.save(post);
		
		Comment comment1 = new Comment(null, post, user2, "Muito bacana!");
		Comment comment2 = new Comment(null, post, user2, "Diga mais sobre esse site!");
		commentRepository.saveAll(Arrays.asList(comment1, comment2));
		
		CommentLike commLike1 = new CommentLike(null, comment1);
		CommentLike commLike2 = new CommentLike(null, comment1);
		CommentLike commLike3 = new CommentLike(null, comment2);
		CommentLike commLike4 = new CommentLike(null, comment2);
		CommentLike commLike5 = new CommentLike(null, comment2);
		commentLikeRepository.saveAll(Arrays.asList(commLike1, commLike2, commLike3, commLike4, commLike5));
	}
	
}
