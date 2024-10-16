package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.LibroModel;

public interface LibroService {

    public void save(Integer id, LibroModel libro);

    public LibroModel getLibroById(Integer id);

    public void delete(Integer id);

    public List<LibroModel> findAll();
}
