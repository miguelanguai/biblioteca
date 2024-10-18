package com.example.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * finds a {@link UserEntity} by passing his username
     * 
     * @param username
     * @return {@link UserEntity}
     */
    Optional<UserEntity> findByUsername(String username);
}
