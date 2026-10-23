package org.uade;

import org.uade.algoritmos.Dijkstra;
import org.uade.entidades.CriterioOrden;
import org.uade.entidades.Publicacion;
import org.uade.entidades.Usuario;
import org.uade.algoritmos.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class Main {
  static void main() {
    ArrayList<Usuario> usuarios = crearUsuarios();
    testearDijkstra(usuarios);
    System.out.println("---------------");

    ArrayList<Publicacion> publicaciones = crearPublicaciones(usuarios.get(0), usuarios.get(1), usuarios.get(2), usuarios.get(3));
    QuickSort.quicksort(publicaciones, CriterioOrden.REACCIONES);
    for (Publicacion publicacion : publicaciones) {
      System.out.println(publicacion);
      System.out.println();
    }
  }

  private static ArrayList<Usuario> crearUsuarios() {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    Usuario usuario01 = new Usuario("Juancho144");
    usuarios.add(usuario01);
    Usuario usuario02 = new Usuario("PedroMartinez");
    usuarios.add(usuario02);
    Usuario usuario03 = new Usuario("niortega");
    usuarios.add(usuario03);
    Usuario usuario04 = new Usuario("MarcosMMacri");
    usuarios.add(usuario04);
    Usuario usuario05 = new Usuario("Pedrito1998");
    usuarios.add(usuario05);
    Usuario usuario06 = new Usuario("Xxx_JoseManos_xxX");
    usuarios.add(usuario06);
    Usuario usuario07 = new Usuario("Juan Perez de Jesus");
    usuarios.add(usuario07);
    Usuario usuario08 = new Usuario("MMM011");
    usuarios.add(usuario08);

    return usuarios;
  }

  private static ArrayList<Publicacion> crearPublicaciones(Usuario usuario01, Usuario usuario02, Usuario usuario03,
      Usuario usuario04) {
    ArrayList<Publicacion> publicaciones = new ArrayList<>();

    Publicacion publicacion01 = new Publicacion.Builder()
        .autor(usuario01)
        .fecha_publicacion()
        .reacciones()
        .num_comentarios()
        .contenido("Me gusta estudiar.")
        .build();
    publicaciones.add(publicacion01);
    Publicacion publicacion02 = new Publicacion.Builder()
        .autor(usuario02)
        .fecha_publicacion()
        .reacciones()
        .num_comentarios()
        .contenido("Estaria bueno si el receso durara 40 minutos.")
        .build();
    publicaciones.add(publicacion02);
    Publicacion publicacion03 = new Publicacion.Builder()
        .autor(usuario03)
        .fecha_publicacion()
        .reacciones()
        .num_comentarios()
        .contenido("No me gusta estudiar")
        .build();
    publicaciones.add(publicacion03);
    Publicacion publicacion04 = new Publicacion.Builder()
        .autor(usuario04)
        .fecha_publicacion()
        .reacciones()
        .num_comentarios()
        .contenido("Tengo cinco parciales el mismo dia ;(")
        .build();
    publicaciones.add(publicacion04);

    return publicaciones;
  }

  private static void testearDijkstra(List<Usuario> usuarios) {
    usuarios.get(0).conectar(usuarios.get(1), 5);
    usuarios.get(1).conectar(usuarios.get(2), 4);
    usuarios.get(0).conectar(usuarios.get(3), 10);
    usuarios.get(2).conectar(usuarios.get(3), 3);

    Usuario origen = usuarios.get(0);
    Usuario destino = usuarios.get(3);
    Usuario inalcanzable = usuarios.get(7);

    Dijkstra.Resultado resultado = Dijkstra.dijkstra(usuarios, origen);

    System.out.println("Tiempo tomado desde " + origen.getNombre() + ":");
    for (Usuario nodo : usuarios) {
      int distancia = resultado.distancias().get(nodo);
      System.out.println("  " + nodo.getNombre() + " -> "
              + (distancia == Integer.MAX_VALUE ? "inalcanzable" : distancia + " min"));
    }

    mostrarCadena(resultado, origen, destino);
    mostrarCadena(resultado, origen, inalcanzable);

    System.out.println("Decisiones tomadas:");
    for (String paso : resultado.pasos()) {
      System.out.println("  " + paso);
    }
  }

  private static void mostrarCadena(Dijkstra.Resultado resultado, Usuario origen, Usuario destino) {
    int distancia = resultado.distancias().get(destino);
    if (distancia == Integer.MAX_VALUE) {
      System.out.println("El destino " + destino.getNombre() + " es inalcanzable desde " + origen.getNombre() + ".");
      return;
    }

    List<Usuario> cadena = new ArrayList<>();
    Usuario cursor = destino;
    while (cursor != null) {
      cadena.add(0, cursor);
      cursor = resultado.predecesores().get(cursor);
    }

    System.out.println("Cadena " + origen.getNombre() + " -> " + destino.getNombre() + ": "
            + cadena.stream().map(Usuario::getNombre).toList() + " en " + distancia + " min");
  }
}
