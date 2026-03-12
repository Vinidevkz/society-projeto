package com.projeto.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
