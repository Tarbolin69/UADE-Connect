package org.uade.entidades;

public class Vinculo {
    private Usuario destino;
    private int minutos;

    public Vinculo(Usuario destino, int minutos) {
        this.destino = destino;
        this.minutos = minutos;
    }

    public Usuario getDestino() {
        return destino;
    }

    public int getMinutos() {
        return minutos;
    }
}
