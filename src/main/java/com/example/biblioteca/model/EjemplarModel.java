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
@Table(name = "ejemplar")
public class EjemplarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ejemplar_id;

    @JsonManagedReference("ejemplar-libros")
    @OneToMany(mappedBy = "ejemplar")
    private List<LibroModel> libros;

    public Integer getEjemplar_id() {
        return ejemplar_id;
    }

    public void setEjemplar_id(Integer ejemplar_id) {
        this.ejemplar_id = ejemplar_id;
    }

    public List<LibroModel> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroModel> libros) {
        this.libros = libros;
    }

}
