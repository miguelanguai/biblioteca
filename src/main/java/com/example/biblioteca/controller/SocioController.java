package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.SocioModel;
import com.example.biblioteca.service.SocioService;

@RestController
@RequestMapping(value = "/socio")
public class SocioController {

    @Autowired
    SocioService socioService;

    @RequestMapping(path = { "/save", "/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody SocioModel tema) {
        this.socioService.save(id, tema);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.GET)
    public SocioModel getSocioById(@PathVariable Integer id) {
        return socioService.getSocioByDni(id);
    }

    @RequestMapping(path = { "/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.socioService.delete(id);
    }

    @RequestMapping(path = { "/all" }, method = RequestMethod.GET)
    public List<SocioModel> findAll() {
        return socioService.findAll();
    }
}
