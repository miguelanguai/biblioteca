package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.EjemplarModel;
import com.example.biblioteca.service.EjemplarService;

@RestController
@RequestMapping(value = "/ejemplar")
public class EjemplarController {
    @Autowired
    EjemplarService ejemplarService;

    @RequestMapping(path = { "/save", "/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody EjemplarModel ejemplar) {
        this.ejemplarService.save(id, ejemplar);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.GET)
    public EjemplarModel getTemaById(@PathVariable Integer id) {
        return ejemplarService.getEjemplarById(id);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.ejemplarService.delete(id);
    }

    @RequestMapping(path = { "/all" }, method = RequestMethod.GET)
    public List<EjemplarModel> findAll() {
        return ejemplarService.findAll();
    }
}
