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

import com.example.biblioteca.model.PrestaModel;
import com.example.biblioteca.service.PrestaService;

@RestController
@RequestMapping(value = "")
public class PrestaController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    PrestaService prestaService;

    @RequestMapping(path = { "/u/presta/save", "/u/presta/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody PrestaModel tema) {
        this.prestaService.save(id, tema);
    }

    @RequestMapping(path = { "/p/presta/{id}" }, method = RequestMethod.GET)
    public PrestaModel getTemaById(@PathVariable Integer id) {
        return prestaService.getPrestaById(id);
    }

    @RequestMapping(path = { "/u/presta/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.prestaService.delete(id);
    }

    @RequestMapping(path = { "/p/presta/all" }, method = RequestMethod.GET)
    public List<PrestaModel> findAll() {
        List<PrestaModel> prestamos = this.prestaService.findAll();
        return prestamos.stream().map(e -> mapper.map(e, PrestaModel.class)).collect(Collectors.toList());
    }
}
