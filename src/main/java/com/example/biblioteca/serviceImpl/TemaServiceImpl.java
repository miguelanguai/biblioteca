package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.TemaModel;
import com.example.biblioteca.repository.TemaRepository;
import com.example.biblioteca.service.TemaService;

@Service
public class TemaServiceImpl implements TemaService {

    @Autowired
    TemaRepository temaRepository;

    @Override
    public void save(Integer id, TemaModel tema) {
        TemaModel savedTema;
        if (id == null) {
            savedTema = new TemaModel();
        } else {
            savedTema = temaRepository.findById(id).orElse(null);
        }
        BeanUtils.copyProperties(tema, savedTema);
        savedTema.setIdTema(id);

        try {
            savedTema = temaRepository.save(savedTema);
        } catch (Exception e) {
            System.out.println("[guardaTema] exception: " + e.getMessage());
        }

    }

    @Override
    public TemaModel getTemaById(Integer id) {
        TemaModel tema = new TemaModel();
        try {
            tema = temaRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getTemaById] exception: " + e.getMessage());
        }
        return tema;
    }

    @Override
    public void delete(Integer id) {
        try {
            this.temaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[delete] exception: Not exists: " + e.getMessage());
        }
        this.temaRepository.deleteById(id);

    }

    @Override
    public List<TemaModel> findAll() {
        return this.temaRepository.findAll();
    }

}
