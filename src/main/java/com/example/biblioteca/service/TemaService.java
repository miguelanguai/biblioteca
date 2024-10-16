package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.TemaModel;

public interface TemaService {
    void save(Integer id, TemaModel tema);

    TemaModel getTemaById(Integer id);

    void delete(Integer id);

    List<TemaModel> findAll();
}
