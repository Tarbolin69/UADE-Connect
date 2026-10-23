package org.uade.algoritmos;

import org.uade.entidades.Usuario;
import org.uade.entidades.Vinculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    public record Resultado(Map<Usuario, Integer> distancias, Map<Usuario, Usuario> predecesores, List<String> pasos) {
    }

    public static Resultado dijkstra(List<Usuario> nodos, Usuario raiz) {
        Map<Usuario, Integer> distancias = new HashMap<>();
        Map<Usuario, Usuario> predecesores = new HashMap<>();
        List<String> pasos = new ArrayList<>();
        PriorityQueue<Usuario> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (Usuario nodo : nodos) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(raiz, 0);
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Usuario u = cola.poll();
            for (Vinculo vinculo : u.getAmigos()) {
                Usuario v = vinculo.getDestino();
                int peso = vinculo.getMinutos();
                int distanciaU = distancias.get(u);
                int distanciaV = distancias.get(v);
                if (distanciaU + peso < distanciaV) {
                    cola.remove(v);
                    distancias.put(v, distanciaU + peso);
                    predecesores.put(v, u);
                    cola.add(v);
                    pasos.add("Toma " + v.getNombre() + " a " + (distanciaU + peso) + " desde " + u.getNombre());
                }
            }
        }
        return new Resultado(distancias, predecesores, pasos);
    }
}
