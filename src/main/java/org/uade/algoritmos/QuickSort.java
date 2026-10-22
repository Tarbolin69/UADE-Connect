package org.uade.algoritmos;

import org.uade.entidades.CriterioOrden;
import org.uade.entidades.Publicacion;

import java.util.ArrayList;

public class QuickSort {

  // O(n^2)
  public static void quicksort(ArrayList<Publicacion> publicaciones, CriterioOrden criterio) {
    quicksort(publicaciones, 0, publicaciones.size() - 1, criterio);
  }

  private static void quicksort(ArrayList<Publicacion> publicaciones, int inicio, int fin, CriterioOrden criterio) {
    // Finaliza el metodo cuando queda un solo elemento
    if (inicio >= fin) {
      return;
    }
    // Crea pivote y el "atras" y "adelante" de la lista
    int indicePivote = particionar(publicaciones, inicio, fin, criterio);
    // QuickSort en la particion izquierda
    quicksort(publicaciones, inicio, indicePivote - 1, criterio);
    // QuickSort en la particion derecha
    quicksort(publicaciones, indicePivote + 1, fin, criterio);
  }

  private static void crearPivote(ArrayList<Publicacion> publicaciones, int inicio, int fin, CriterioOrden criterio) {
    int medio = inicio + (fin - inicio) / 2;
    if (comparar(publicaciones.get(inicio), publicaciones.get(medio), criterio) > 0) {
      intercambiar(publicaciones, inicio, medio);
    }
    if (comparar(publicaciones.get(inicio), publicaciones.get(fin), criterio) > 0) {
      intercambiar(publicaciones, inicio, fin);
    }
    if (comparar(publicaciones.get(medio), publicaciones.get(fin), criterio) > 0) {
      intercambiar(publicaciones, medio, fin);
    }
    intercambiar(publicaciones, inicio, medio);
  }

  private static int particionar(ArrayList<Publicacion> publicaciones, int inicio, int fin, CriterioOrden criterio) {
    crearPivote(publicaciones, inicio, fin, criterio);
    Publicacion pivote = publicaciones.get(inicio);
    int izquierda = inicio;
    int derecha = fin + 1;
    while (true) {
      while (comparar(publicaciones.get(++izquierda), pivote, criterio) < 0) {
        if (izquierda == fin) {
          break;
        }
      }
      while (comparar(publicaciones.get(--derecha), pivote, criterio) > 0) {
        if (derecha == inicio) {
          break;
        }
      }
      if (izquierda >= derecha) {
        break;
      }
      intercambiar(publicaciones, izquierda, derecha);
    }
    intercambiar(publicaciones, inicio, derecha);
    return derecha;
  }

  private static int comparar(Publicacion a, Publicacion b, CriterioOrden criterio) {
    return switch (criterio) {
      // Prioriza fecha si tienen la misma cantidad de reacciones
      case REACCIONES -> {
        int comparacionPorReacciones = Integer.compare(b.getReacciones(), a.getReacciones());
        if (comparacionPorReacciones != 0) {
          yield comparacionPorReacciones;
        }
        yield b.getFecha_publicacion().compareTo(a.getFecha_publicacion());
      }
      case FECHA_PUBLICACION -> b.getFecha_publicacion().compareTo(a.getFecha_publicacion());
    };
  }

  private static void intercambiar(ArrayList<Publicacion> publicaciones, int i, int j) {
    Publicacion temporal = publicaciones.get(i);
    publicaciones.set(i, publicaciones.get(j));
    publicaciones.set(j, temporal);
  }
}
