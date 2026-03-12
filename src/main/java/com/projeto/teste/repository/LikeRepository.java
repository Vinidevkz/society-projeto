package com.projeto.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entities.PostLike;

public interface LikeRepository extends JpaRepository<PostLike, Long> {

}
