package com.company.spring_boot_crud_app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase de entidad que representa un Producto en la base de datos.
 * Un producto tiene un ID, un nombre y un precio.
 */
@Entity
@Table(name = "notas") // Mapea esta entidad a la tabla "productos" en la base de datos
public class Nota {

    /**
     * Campo ID que actúa como clave primaria en la tabla de la base de datos.
     * Se auto-genera con una estrategia de identidad (autoincremental).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Campo para almacenar el nombre del producto.
     * Esta columna no puede ser nula (nullable = false).
     */
    @Column(nullable = false)
    private String titulo;

    /**
     * Campo para almacenar el precio del producto.
     * Esta columna no puede ser nula (nullable = false).
     */
    @Column(nullable = false)
    private String contenido;

    // Relación Many-to-One con la entidad Carpeta
    // @ManyToOne
    // @JoinColumn(name = "carpeta_id")
    // private Carpeta carpeta;

    private Long carpeta_id; //Id de la carpeta

    /**
     * Constructor vacío requerido por JPA.
     * JPA (Java Persistence API) necesita un constructor sin parámetros para poder
     * instanciar la entidad.
     */
    public Nota() {
    }

    /**
     * Constructor que permite crear un Producto con un nombre y precio.
     * 
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     */
    public Nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    /**
     * Obtiene el ID del producto.
     * 
     * @return El ID del producto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     * 
     * @param id El ID del producto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param titulo El nombre del producto.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param precio El precio del producto.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getCarpeta_id() {
        return carpeta_id;
    }

    public void setCarpeta_id(Long carpeta_id) {
        this.carpeta_id = carpeta_id;
    }
}
