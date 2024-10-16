package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.SocioModel;
import com.example.biblioteca.repository.SocioRepository;
import com.example.biblioteca.service.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    SocioRepository socioRepository;

    @Override
    public void save(Integer id, SocioModel socio) {
        SocioModel savedSocio;
        if (id == null) {
            savedSocio = new SocioModel();
        } else {
            savedSocio = socioRepository.findById(id).orElse(null);
        }
        savedSocio.setNombre(socio.getNombre());
        savedSocio.setDomicilio(socio.getDomicilio());
        savedSocio.setTelefono(socio.getTelefono());

        try {
            savedSocio = socioRepository.save(savedSocio);
        } catch (Exception e) {
            System.out.println("[guardaSocio] exception: " + e.getMessage());
        }

    }

    @Override
    public SocioModel getSocioById(Integer id) {
        SocioModel socio = new SocioModel();
        try {
            socio = socioRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getSocioById] exception: " + e.getMessage());
        }
        return socio;
    }

    @Override
    public void delete(Integer id) {
        try {
            this.socioRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[delete] exception: Not exists: " + e.getMessage());
        }
        this.socioRepository.deleteById(id);

    }

    @Override
    public List<SocioModel> findAll() {
        return this.socioRepository.findAll();
    }

}
