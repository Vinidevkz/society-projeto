package com.projeto.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
