package com.projeto.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
