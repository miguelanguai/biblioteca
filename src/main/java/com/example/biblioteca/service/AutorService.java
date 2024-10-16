package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.AutorModel;

public interface AutorService {

    void save(Integer id, AutorModel autor);

    AutorModel getAutorById(Integer id);

    void delete(Integer id);

    List<AutorModel> findAll();

}
