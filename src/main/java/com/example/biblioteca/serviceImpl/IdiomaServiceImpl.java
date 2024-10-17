package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.repository.IdiomaRepository;
import com.example.biblioteca.service.IdiomaService;

@Service
public class IdiomaServiceImpl implements IdiomaService {

    @Autowired
    IdiomaRepository idiomaRepository;

    @Override
    public void save(Integer id, IdiomaModel idioma) {
        IdiomaModel savedIdioma;
        if (id == null) {
            savedIdioma = new IdiomaModel();
        } else {
            savedIdioma = idiomaRepository.findById(id).orElse(null);
        }
        BeanUtils.copyProperties(idioma, savedIdioma);

        try {
            savedIdioma = idiomaRepository.save(savedIdioma);
        } catch (Exception e) {
            System.out.println("[guardaIdioma] exception: " + e.getMessage());
        }
    }

    @Override
    public IdiomaModel getIdiomaById(Integer id) {
        IdiomaModel idioma = new IdiomaModel();
        try {
            idioma = idiomaRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getIdiomaById] exception: " + e.getMessage());
        }

        return idioma;
    }

    @Override
    public void delete(Integer id) {
        try {
            this.idiomaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[delete] exception: Not exists: " + e.getMessage());
        }
        this.idiomaRepository.deleteById(id);
    }

    @Override
    public List<IdiomaModel> findAll() {
        return this.idiomaRepository.findAll();
    }

}
