package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.EjemplarModel;

public interface EjemplarService {
    void save(Integer id, EjemplarModel ejemplar);

    EjemplarModel getEjemplarById(Integer id);

    void delete(Integer id);

    List<EjemplarModel> findAll();
}
