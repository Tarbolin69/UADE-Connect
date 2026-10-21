package org.uade.data;

import java.util.Date;

public class Publicacion {
    private int id;
    private Usuario autor;
    private Date fecha_publicacion;
    private int reacciones;
    private int num_comentarios;

    public Publicacion(Usuario autor, Date fecha_publicacion, int reacciones, int num_comentarios) {
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
        this.reacciones = reacciones;
        this.num_comentarios = num_comentarios;
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
}
