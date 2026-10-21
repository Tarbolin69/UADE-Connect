package org.uade.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

public class Publicacion {
    private String id; ;
    private Usuario autor;
    private LocalDateTime fecha_publicacion;
    private int reacciones;
    private int num_comentarios;
    private String contenido;

    public Publicacion(Usuario autor, LocalDateTime fecha_publicacion, int reacciones, int num_comentarios, String contenido) {
        this.id = UUID.randomUUID().toString(); // IDs unicas
        this.autor = autor;
        // Si fuera una app con DB y persistencia
        // this.fecha_publicacion = LocalDateTime.now();
        this.fecha_publicacion = fecha_publicacion; // Para testear usamos fechas "falsas"
        this.reacciones = reacciones;
        this.num_comentarios = num_comentarios;
        this.contenido = contenido;
    }

    public String getId() {
        return id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public LocalDateTime getFecha_publicacion() {
        return fecha_publicacion;
    }

    public int getReacciones() {
        return reacciones;
    }

    public int getNum_comentarios() {
        return num_comentarios;
    }

    public String getContenido() {
        return contenido;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setFecha_publicacion(LocalDateTime fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public void setReacciones(int reacciones) {
        this.reacciones = reacciones;
    }

    public void setNum_comentarios(int num_comentarios) {
        this.num_comentarios = num_comentarios;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
