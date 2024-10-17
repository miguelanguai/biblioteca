package com.example.biblioteca.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "presta")
public class PrestaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPresta;

    @ManyToOne
    @JoinColumn(name = "idEjemplar", nullable = false)
    private EjemplarModel ejemplar;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false)
    private SocioModel socio;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;

    public Integer getIdPresta() {
        return idPresta;
    }

    public void setIdPresta(Integer idPresta) {
        this.idPresta = idPresta;
    }

    public EjemplarModel getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(EjemplarModel ejemplar) {
        this.ejemplar = ejemplar;
    }

    public SocioModel getSocio() {
        return socio;
    }

    public void setSocio(SocioModel socio) {
        this.socio = socio;
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
