package org.uade;

import org.uade.entidades.Publicacion;
import org.uade.entidades.Usuario;

import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Usuario> usuarios = crearUsuarios();
        ArrayList<Publicacion> publicaciones = crearPublicaciones(usuarios.get(0), usuarios.get(1), usuarios.get(2), usuarios.get(3));

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

        return usuarios;
    }
    private static ArrayList<Publicacion> crearPublicaciones(Usuario usuario01, Usuario usuario02, Usuario usuario03, Usuario usuario04) {
        ArrayList<Publicacion> publicaciones = new ArrayList<>();

        Publicacion publicacion01 = new Publicacion.Builder()
                .autor(usuario01)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar")
                .build();
        publicaciones.add(publicacion01);
        Publicacion publicacion02 = new Publicacion.Builder()
                .autor(usuario02)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar")
                .build();
        publicaciones.add(publicacion02);
        Publicacion publicacion03 = new Publicacion.Builder()
                .autor(usuario03)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar")
                .build();
        publicaciones.add(publicacion03);
        Publicacion publicacion04 = new Publicacion.Builder()
                .autor(usuario04)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar")
                .build();
        publicaciones.add(publicacion04);

        return publicaciones;
    }
}
