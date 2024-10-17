package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.EjemplarModel;
import com.example.biblioteca.repository.EjemplarRepository;
import com.example.biblioteca.service.EjemplarService;

@Service
public class EjemplarServiceImpl implements EjemplarService {

    @Autowired
    EjemplarRepository ejemplarRepository;

    @Override
    public void save(Integer id, EjemplarModel ejemplar) {
        EjemplarModel savedEjemplar;
        if (id == null) {
            savedEjemplar = new EjemplarModel();
        } else {
            savedEjemplar = ejemplarRepository.findById(id).orElse(null);
        }
        BeanUtils.copyProperties(ejemplar, savedEjemplar);
        savedEjemplar.setEjemplar_id(id);

        try {
            savedEjemplar = ejemplarRepository.save(savedEjemplar);
        } catch (Exception e) {
            System.out.println("[guardaEjemplar] exception: " + e.getMessage());
        }

    }

    @Override
    public EjemplarModel getEjemplarById(Integer id) {
        EjemplarModel ejemplar = new EjemplarModel();
        try {
            ejemplar = ejemplarRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getEjemplarById] exception: " + e.getMessage());
        }
        return ejemplar;
    }

    @Override
    public void delete(Integer id) {
        try {
            this.ejemplarRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[delete] exception: Not exists: " + e.getMessage());
        }
        this.ejemplarRepository.deleteById(id);

    }

    @Override
    public List<EjemplarModel> findAll() {
        return this.ejemplarRepository.findAll();
    }

}
