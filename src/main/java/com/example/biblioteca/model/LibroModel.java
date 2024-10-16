package com.example.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class LibroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLibro;

    private Integer anio;

    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    private IdiomaModel idioma;

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public IdiomaModel getIdioma() {
        return idioma;
    }

    public void setIdioma(IdiomaModel idioma) {
        this.idioma = idioma;
    }

}
