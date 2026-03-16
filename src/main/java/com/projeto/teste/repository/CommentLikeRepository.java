package com.projeto.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entities.Comment;
import com.projeto.teste.entities.CommentLike;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

}
