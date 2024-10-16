package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public void save(Integer id, LibroModel libro) {
        LibroModel savedLibro;
        if (id == null) {
            savedLibro = new LibroModel();
        } else {
            savedLibro = libroRepository.findById(id).orElse(null);
        }
        savedLibro.setAnio(libro.getAnio());
        savedLibro.setIdioma(libro.getIdioma());
        savedLibro.setTitulo(libro.getTitulo());

        try {
            this.libroRepository.save(savedLibro);
        } catch (Exception e) {
            System.out.println("[guardaLibro] exception: " + e.getMessage());
        }
    }

    @Override
    public LibroModel getLibroById(Integer idLibro) {
        LibroModel result = new LibroModel();
        try {
            result = libroRepository.findById(idLibro).get();
        } catch (Exception e) {
            System.out.println("[getLibroById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public void delete(Integer id) {
        try {
            this.libroRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[getLibroById] exception: Not exists: " + e.getMessage());
        }
        this.libroRepository.deleteById(id);
    }

    @Override
    public List<LibroModel> findAll() {
        return this.libroRepository.findAll();
    }

}
