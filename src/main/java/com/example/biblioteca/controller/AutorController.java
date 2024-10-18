package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.AutorModel;
import com.example.biblioteca.service.AutorService;

@RestController
@RequestMapping(value = "")
public class AutorController {

    @Autowired
    AutorService autorService;

    @RequestMapping(path = { "/u/autor/save", "/u/autor/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody AutorModel autor) {
        autorService.save(id, autor);
    }

    @GetMapping(value = "/p/autor/{id}")
    public AutorModel getAutorById(@PathVariable Integer id) {
        return autorService.getAutorById(id);
    }

    @RequestMapping(path = { "/u/autor/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.autorService.delete(id);
    }

    @RequestMapping(path = { "/p/autor/all" }, method = RequestMethod.GET)
    public List<AutorModel> findAll() {
        return autorService.findAll();
    }
}
