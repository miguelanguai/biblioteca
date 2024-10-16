package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.IdiomaModel;

public interface IdiomaService {

    public void save(Integer id, IdiomaModel libro);

    public IdiomaModel getIdiomaById(Integer id);

    public void delete(Integer id);

    public List<IdiomaModel> findAll();
}
