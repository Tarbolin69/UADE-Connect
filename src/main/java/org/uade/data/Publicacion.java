package org.uade.data;

import java.util.Date;

public class Publicacion {
    private int id;
    private Usuario autor;
    private Date fecha_publicacion;
    private int reacciones;
    private int num_comentarios;
    private String contenido;

    public Publicacion(int id, Usuario autor, Date fecha_publicacion, int reacciones, int num_comentarios, String contenido) {
        this.id = id;
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
        this.reacciones = reacciones;
        this.num_comentarios = num_comentarios;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Date getFecha_publicacion() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
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
