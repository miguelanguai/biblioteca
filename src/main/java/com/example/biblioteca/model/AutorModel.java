package com.example.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class AutorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAutor;

    String nombre;

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private List<LibroModel> libros;

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LibroModel> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroModel> libros) {
        this.libros = libros;
    }

}
