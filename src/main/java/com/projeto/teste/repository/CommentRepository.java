package com.projeto.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
