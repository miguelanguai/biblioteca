package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.AutorModel;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public void save(Integer id, AutorModel autor) {
        AutorModel savedAuthor;
        if (id == null) {
            savedAuthor = new AutorModel();
        } else {
            savedAuthor = autorRepository.findById(id).orElse(null);
        }
        savedAuthor.setNombre(autor.getNombre());
        savedAuthor.setLibroId(autor.getLibroId());

        try {
            savedAuthor = autorRepository.save(savedAuthor);
        } catch (Exception e) {
            System.out.println("[guardaAutor] exception: " + e.getMessage());
        }

    }

    @Override
    public AutorModel getAutorById(Integer id) {
        AutorModel autor = new AutorModel();
        try {
            autor = autorRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getAutorById] exception: " + e.getMessage());
        }
        return autor;
    }

    @Override
    public void delete(Integer id) {
        try {
            this.autorRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[delete] exception: Not exists: " + e.getMessage());
        }
        this.autorRepository.deleteById(id);

    }

    @Override
    public List<AutorModel> findAll() {
        return this.autorRepository.findAll();
    }

}
