package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.LibroModel;

@Repository
public interface LibroRepository extends JpaRepository<LibroModel, Integer> {

}
