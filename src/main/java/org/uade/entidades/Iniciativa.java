package org.uade.entidades;

import java.util.UUID;

public class Iniciativa {
    private String id = UUID.randomUUID().toString();
    private String descripcion;
    private int costo;
    private int impacto;

    public Iniciativa(Builder builder) {
        this.descripcion = builder.descripcion;
        this.costo = builder.costo;
        this.impacto = builder.impacto;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public int getImpacto() {
        return impacto;
    }

    public static class Builder {
        private String descripcion;
        private int costo;
        private int impacto;

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder costo(int costo) {
            this.costo = costo;
            return this;
        }

        public Builder impacto(int impacto) {
            this.impacto = impacto;
            return this;
        }

        public Iniciativa build() {
            return new Iniciativa(this);
        }
    }

    @Override
    public String toString() {
        return """
            Descripcción:
                %s
            Costo: %d
            Impacto: %d
            -----------------""".formatted(descripcion, costo, impacto);
    }
}
