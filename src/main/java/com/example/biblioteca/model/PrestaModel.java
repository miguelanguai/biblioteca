package com.example.biblioteca.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "presta")
public class PrestaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPresta;

    private Integer idLibro;

    private Integer idEjemplar;

    private Integer dniSocio;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;

    public Integer getIdPresta() {
        return idPresta;
    }

    public void setIdPresta(Integer idPresta) {
        this.idPresta = idPresta;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Integer getDniSocio() {
        return dniSocio;
    }

    public void setDniSocio(Integer dniSocio) {
        this.dniSocio = dniSocio;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
