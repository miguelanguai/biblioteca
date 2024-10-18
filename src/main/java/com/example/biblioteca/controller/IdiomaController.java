package com.example.biblioteca.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
@RequestMapping(value = "")
public class IdiomaController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    IdiomaService idiomaService;

    @RequestMapping(path = { "/u/idioma/save", "/u/idioma/save/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Integer id, @RequestBody IdiomaModel idioma) {
        idiomaService.save(id, idioma);
    }

    @GetMapping(value = "/p/idioma/{id}")
    public IdiomaModel getIdiomaById(@PathVariable Integer id) {
        return idiomaService.getIdiomaById(id);
    }

    @RequestMapping(path = { "/u/idioma/{id}" }, method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        this.idiomaService.delete(id);
    }

    @RequestMapping(path = { "/p/idioma/all" }, method = RequestMethod.GET)
    public List<IdiomaModel> findAll() {
        List<IdiomaModel> idiomas = this.idiomaService.findAll();
        return idiomas.stream().map(e -> mapper.map(e, IdiomaModel.class)).collect(Collectors.toList());
    }
}
