package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.PrestaModel;
import com.example.biblioteca.repository.PrestaRepository;
import com.example.biblioteca.service.PrestaService;

@Service
public class PrestaServiceImpl implements PrestaService {

    @Autowired
    PrestaRepository prestaRepository;

    @Override
    public void save(Integer id, PrestaModel presta) {
        PrestaModel savedPresta;
        if (id == null) {
            savedPresta = new PrestaModel();
        } else {
            savedPresta = prestaRepository.findById(id).orElse(null);
        }
        BeanUtils.copyProperties(presta, savedPresta);
        savedPresta.setIdPresta(id);

        try {
            savedPresta = prestaRepository.save(savedPresta);
        } catch (Exception e) {
            System.out.println("[guardaPrestamo] exception: " + e.getMessage());
        }
    }

    @Override
    public PrestaModel getPrestaById(Integer id) {
        PrestaModel presta = new PrestaModel();
        try {
            presta = prestaRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getPrestaById] exception: " + e.getMessage());
        }
        return presta;
    }

    @Override
    public void delete(Integer id) {
        try {
            this.prestaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[delete] exception: Not exists: " + e.getMessage());
        }
        this.prestaRepository.deleteById(id);

    }

    @Override
    public List<PrestaModel> findAll() {
        return this.prestaRepository.findAll();
    }

}
