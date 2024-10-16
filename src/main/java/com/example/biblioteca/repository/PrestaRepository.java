package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.PrestaModel;

@Repository
public interface PrestaRepository extends JpaRepository<PrestaModel, Integer> {

}
