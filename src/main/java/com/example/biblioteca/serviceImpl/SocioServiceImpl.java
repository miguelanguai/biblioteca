package com.example.biblioteca.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
    public void save(Integer dni, SocioModel socio) {
        SocioModel savedSocio;
        if (dni == null) {
            savedSocio = new SocioModel();
        } else {
            savedSocio = socioRepository.findById(dni).orElse(null);
        }
        BeanUtils.copyProperties(socio, savedSocio);
        savedSocio.setDni(dni);

        try {
            savedSocio = socioRepository.save(savedSocio);
        } catch (Exception e) {
            System.out.println("[guardaSocio] exception: " + e.getMessage());
        }

    }

    @Override
    public SocioModel getSocioByDni(Integer dni) {
        SocioModel socio = new SocioModel();
        try {
            socio = socioRepository.findById(dni).orElse(null);
        } catch (Exception e) {
            System.out.println("[getSocioById] exception: " + e.getMessage());
        }
        return socio;
    }

    @Override
    public void delete(Integer dni) {
        try {
            this.socioRepository.findById(dni).orElse(null);
        } catch (Exception e) {
            System.out.println("[delete] exception: Not exists: " + e.getMessage());
        }
        this.socioRepository.deleteById(dni);

    }

    @Override
    public List<SocioModel> findAll() {
        return this.socioRepository.findAll();
    }

}
