package org.uade.entidades;

public class Vinculo {
    private Usuario origen;
    private Usuario destino;
    private int minutos;

    public Vinculo(Usuario origen, Usuario destino, int minutos) {
        this.origen = origen;
        this.destino = destino;
        this.minutos = minutos;
    }

    public Usuario getOrigen() {
        return origen;
    }

    public Usuario getDestino() {
        return destino;
    }

    public int getMinutos() {
        return minutos;
    }
}
