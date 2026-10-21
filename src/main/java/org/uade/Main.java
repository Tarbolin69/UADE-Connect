package org.uade;

import org.uade.entidades.Publicacion;
import org.uade.entidades.Usuario;

public class Main {
    static void main() {
        Usuario usuario01 = new Usuario("Juancho144");
        Usuario usuario02 = new Usuario("PedroMartinez");
        Usuario usuario03 = new Usuario("niortega");
        Usuario usuario04 = new Usuario("MarcosMMacri");

        Publicacion.Builder publicacion01 = new Publicacion.Builder()
                .autor(usuario01)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar");
        Publicacion.Builder publicacion02 = new Publicacion.Builder()
                .autor(usuario02)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar");
        Publicacion.Builder publicacion03 = new Publicacion.Builder()
                .autor(usuario03)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar");
        Publicacion.Builder publicacion04 = new Publicacion.Builder()
                .autor(usuario04)
                .fecha_publicacion()
                .reacciones()
                .num_comentarios()
                .contenido("Me gusta estudiar");
    }
}
