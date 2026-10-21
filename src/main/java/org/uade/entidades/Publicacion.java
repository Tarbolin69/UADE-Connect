package org.uade.entidades;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Publicacion {
    private String id = UUID.randomUUID().toString(); ;
    private Usuario autor;
    private LocalDateTime fecha_publicacion;
    private int reacciones;
    private int num_comentarios;
    private String contenido;

    public Publicacion(Builder builder) {
        this.autor = builder.autor;
        this.fecha_publicacion = builder.fecha_publicacion;
        this.reacciones = builder.reacciones;
        this.num_comentarios = builder.num_comentarios;
        this.contenido = builder.contenido;
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

    public static class Builder {
        private Usuario autor;
        private LocalDateTime fecha_publicacion;
        private int reacciones;
        private int num_comentarios;
        private String contenido;

        public Builder autor(Usuario autor) {
            this.autor = autor;
            return this;
        }
        public Builder fecha_publicacion() {
            LocalDateTime ahora = LocalDateTime.now();
            LocalDateTime limite = ahora.minusWeeks(1);
            long segunos = Duration.between(limite, ahora).getSeconds();
            LocalDateTime fecha_rand = limite.plusSeconds(ThreadLocalRandom.current().nextLong(segunos + 1));
            this.fecha_publicacion = fecha_rand;
            return this;
        }
        public Builder reacciones() {
            this.reacciones = ThreadLocalRandom.current().nextInt(1, 201);
            return this;
        }
        public Builder num_comentarios() {
            this.num_comentarios = ThreadLocalRandom.current().nextInt(1, 21);
            return this;
        }
        public Builder contenido(String contenido) {
            this.contenido = contenido;
            return this;
        }
    }
}
