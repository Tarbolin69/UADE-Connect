package org.uade.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    private String nombre;
    private String id;
    private List<Vinculo> amigos = new ArrayList<>();

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

    public List<Vinculo> getAmigos() {
        return amigos;
    }

    public void conectar(Usuario destino, int minutos) {
        amigos.add(new Vinculo(destino, minutos));
    }
}
