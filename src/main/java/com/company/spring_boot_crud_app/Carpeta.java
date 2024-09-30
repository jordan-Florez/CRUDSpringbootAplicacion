package com.company.spring_boot_crud_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Carpeta")
public class Carpeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    private Usuario usuario;

    //@OneToMany(mappedBy = "carpeta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Nota> notas;
    //@OneToMany(mappedBy = "carpeta", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Nota> notas = new ArrayList<>();
    

    // Constructores
    public Carpeta() {
    }

    public Carpeta(String nombre, Usuario usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // public List<Nota> getNotas() {
    //     return notas;
    // }

    // public void setNotas(List<Nota> notas) {
    //     this.notas = notas;
    // }
}
