/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import dominio.Administrador;
import dominio.Anclada;
import dominio.Comentario;
import dominio.Comun;
import dominio.Credencial;
import dominio.Estado;
import dominio.Genero;
import dominio.Municipio;
import dominio.Normal;
import dominio.Publicacion;
import dominio.Usuario;
import fachada.FachadaPersistencia;
import fachada.IFachadaPersistencia;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author HP
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IFachadaPersistencia fachada = new FachadaPersistencia();

        //Registrar cliente Normal
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2002);
        calendar.set(Calendar.MONTH, Calendar.JUNE);
        calendar.set(Calendar.DAY_OF_MONTH, 7);
        Date fechaNacimiento = calendar.getTime();

        Usuario usuarioNormal = new Normal("Daniel Omar", "Alameda",
                "López", "6442121807", "Daoma", "cd. Obregón",
                fechaNacimiento, Genero.MASCULINO,
                new Credencial("daniel222@gmail.com", "123"), new Municipio("Cajeme", new Estado("Sonora")));

        fachada.registrarUsuario(usuarioNormal);

        //Registrar cliente Administrador
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.YEAR, 2000);
        calendar2.set(Calendar.MONTH, Calendar.APRIL);
        calendar2.set(Calendar.DAY_OF_MONTH, 20);
        Date fechaNacimiento2 = calendar.getTime();

        Usuario usuarioAdministrador = new Administrador("Carlos Alberto", "López",
                "Jusaino", "6442587496", "carlos123", "cd. Obregón",
                fechaNacimiento2, Genero.MASCULINO,
                new Credencial("carlosJs@hotmail.com", "carLopez"), new Municipio("Cajeme", new Estado("Sonora")));

        fachada.registrarUsuario(usuarioAdministrador);

        //Registrar publicación Comun por un usuario Normal
        Usuario usuario = new Normal();
        usuario.setId(usuarioNormal.getId());
        usuario.setAvatar(usuarioNormal.getAvatar());
        calendar = Calendar.getInstance();
        Date hoy = calendar.getTime();
        Publicacion publicacionComun = new Comun(usuario, hoy, "¿Qué es el universo?", "Solo se que nose nada");

        fachada.registrarPublicacionComun((Comun) publicacionComun);

        //Registrar publicación Anclada por un usuario Administrador
        Administrador usuarioAdmin = new Administrador();
        usuarioAdmin.setId(usuarioAdministrador.getId());
        usuarioAdmin.setAvatar(usuarioAdministrador.getAvatar());
        calendar = Calendar.getInstance();
        hoy = calendar.getTime();
        Publicacion publicacionAnclada = new Anclada(usuarioAdmin, hoy, "Las noticias", "Este día hara mucho calor");

        fachada.registrarPublicacionAnclada((Anclada) publicacionAnclada);

        //Registrar Comentario 
        calendar = Calendar.getInstance();
        hoy = calendar.getTime();

        Comun publicacion = new Comun();
        publicacion.setId(publicacionComun.getId());
        publicacion.setTitulo(publicacionComun.getTitulo());
        Comentario comentario = new Comentario(hoy, "Es muy interestane",
                (Normal) usuario,
                publicacion);
        fachada.registrarComentario(comentario);

        //Se elimina la publicación comun
        fachada.eliminarPublicacion(publicacionComun);

        //Se elemina un comentario
        fachada.eliminarComentario(comentario);

        //Registrar nuevamente publicación Comun por un usuario Normal
        usuario = new Normal();
        usuario.setId(usuarioNormal.getId());
        usuario.setAvatar(usuarioNormal.getAvatar());
        calendar = Calendar.getInstance();
        hoy = calendar.getTime();
        publicacionComun = new Comun(usuario, hoy, "¿Qué es el universo?", "Solo se que nose nada");

        fachada.registrarPublicacionComun((Comun) publicacionComun);

        //Editar Publicación
        publicacionComun.setContenido("Lo edite");
        fachada.editarPublicacionComun((Comun) publicacionComun);

        //Mostrar Publicaciones
        List<Publicacion> publicaciones = fachada.consultarPublicaciones();
        for (int i = 0; i < publicaciones.size(); i++) {
            publicaciones.get(i).toString();
        }

    }

}
