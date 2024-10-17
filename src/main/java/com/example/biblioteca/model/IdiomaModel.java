package com.example.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "idioma")
public class IdiomaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idioma_id;

    String descripcion;

    @JsonManagedReference("idioma-libros")
    @OneToMany(mappedBy = "idioma")
    List<LibroModel> libros;

    public Integer getIdioma_id() {
        return idioma_id;
    }

    public void setIdioma_id(Integer idioma_id) {
        this.idioma_id = idioma_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LibroModel> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroModel> libros) {
        this.libros = libros;
    }

}
