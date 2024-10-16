package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.PrestaModel;

public interface PrestaService {
    void save(Integer id, PrestaModel tema);

    PrestaModel getPrestaById(Integer id);

    void delete(Integer id);

    List<PrestaModel> findAll();
}
