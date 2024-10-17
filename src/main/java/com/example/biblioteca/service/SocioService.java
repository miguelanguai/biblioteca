package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.SocioModel;

public interface SocioService {
    void save(Integer dni, SocioModel tema);

    SocioModel getSocioByDni(Integer dni);

    void delete(Integer dni);

    List<SocioModel> findAll();
}
