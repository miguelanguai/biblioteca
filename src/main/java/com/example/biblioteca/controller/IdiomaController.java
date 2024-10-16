package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.service.IdiomaService;

@RestController
@RequestMapping(value = "/idioma")
public class IdiomaController {

    @Autowired
    IdiomaService idiomaService;

    @RequestMapping(path = { "/save", "/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody IdiomaModel idioma) {
        idiomaService.save(id, idioma);
    }

    @GetMapping(value = "/{id}")
    public IdiomaModel getIdiomaById(@PathVariable Integer id) {
        return idiomaService.getIdiomaById(id);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.idiomaService.delete(id);
    }

    @RequestMapping(path = { "/all" }, method = RequestMethod.GET)
    public List<IdiomaModel> findAll() {
        return idiomaService.findAll();
    }
}
