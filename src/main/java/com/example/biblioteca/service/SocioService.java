package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.SocioModel;

public interface SocioService {
    void save(Integer id, SocioModel tema);

    SocioModel getSocioById(Integer id);

    void delete(Integer id);

    List<SocioModel> findAll();
}
