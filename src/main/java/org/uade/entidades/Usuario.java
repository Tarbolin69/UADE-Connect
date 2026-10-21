package org.uade.entidades;

import java.util.UUID;

public class Usuario {
    private String nombre;
    private String id;

    public Usuario(String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
}
