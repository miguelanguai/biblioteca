package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.PrestaModel;
import com.example.biblioteca.service.PrestaService;

@RestController
@RequestMapping(value = "/presta")
public class PrestaController {

    @Autowired
    PrestaService prestaService;

    @RequestMapping(path = { "/save", "/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody PrestaModel tema) {
        this.prestaService.save(id, tema);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.GET)
    public PrestaModel getTemaById(@PathVariable Integer id) {
        return prestaService.getPrestaById(id);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.prestaService.delete(id);
    }

    @RequestMapping(path = { "/all" }, method = RequestMethod.GET)
    public List<PrestaModel> findAll() {
        return prestaService.findAll();
    }
}
