package com.example.biblioteca.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.TemaModel;
import com.example.biblioteca.service.TemaService;

@RestController
@RequestMapping(value = "")
public class TemaController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    TemaService temaService;

    @RequestMapping(path = { "/u/tema/save", "/u//temasave/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody TemaModel tema) {
        this.temaService.save(id, tema);
    }

    @RequestMapping(path = { "/p/tema/{id}" }, method = RequestMethod.GET)
    public TemaModel getTemaById(@PathVariable Integer id) {
        return temaService.getTemaById(id);
    }

    @RequestMapping(path = { "/u/tema/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.temaService.delete(id);
    }

    @RequestMapping(path = { "/p/tema/all" }, method = RequestMethod.GET)
    public List<TemaModel> findAll() {
        List<TemaModel> temas = this.temaService.findAll();
        return temas.stream().map(e -> mapper.map(e, TemaModel.class)).collect(Collectors.toList());
    }

}
