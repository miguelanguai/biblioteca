package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.SocioModel;

@Repository
public interface SocioRepository extends JpaRepository<SocioModel, Integer> {

}
