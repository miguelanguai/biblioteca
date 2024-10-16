package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.service.LibroService;

@RestController
@RequestMapping(value = "/libro")
public class LibroController {

    @Autowired
    LibroService libroService;

    @RequestMapping(path = { "/save", "/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody LibroModel libro) {
        this.libroService.save(id, libro);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.GET)
    public LibroModel getLibroById(@PathVariable Integer id) {
        return libroService.getLibroById(id);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.libroService.delete(id);
    }

    @RequestMapping(path = { "/all" }, method = RequestMethod.GET)
    public List<LibroModel> findAll() {
        return libroService.findAll();
    }
}
