package com.example.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @JsonBackReference("idioma-libros")
    @ManyToOne
    @JoinColumn(name = "idioma_id")
    private IdiomaModel idioma;

    @ManyToMany
    @JoinTable(name = "libro_autor", joinColumns = @JoinColumn(name = "idLibro"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<AutorModel> autores;

    @ManyToMany
    @JoinTable(name = "libro_tema", joinColumns = @JoinColumn(name = "idLibro"), inverseJoinColumns = @JoinColumn(name = "tema_id"))
    private List<TemaModel> temas;

    @JsonBackReference("ejemplar-libros")
    @ManyToOne
    @JoinColumn(name = "ejemplar_id")
    private EjemplarModel ejemplar;

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

    public List<AutorModel> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorModel> autores) {
        this.autores = autores;
    }

    public List<TemaModel> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaModel> temas) {
        this.temas = temas;
    }

}
