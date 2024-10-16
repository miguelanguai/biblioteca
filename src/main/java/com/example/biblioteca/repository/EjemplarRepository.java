package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.EjemplarModel;

public interface EjemplarRepository extends JpaRepository<EjemplarModel, Integer> {

}
