/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Comentario;
import dominio.Usuario;
import fachada.IFachadaPersistencia;
import interfaces.IComentarioDAO;
import interfaces.IComentarioNegocio;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author HP
 */
public class ComentarioNegocio implements IComentarioNegocio {

    private final IFachadaPersistencia fachadaPersistencia;

    public ComentarioNegocio(IFachadaPersistencia fachadaPersistencia) {
        this.fachadaPersistencia = fachadaPersistencia;
    }

    @Override
    public Comentario registrarComentario(Comentario comentario) {
        if (comentario == null) {
            throw new IllegalArgumentException("El comentario no puede ser nulo");
        }

        if (comentario.getFechaHora() == null) {
            comentario.setFechaHora(Calendar.getInstance());
        }

        // Validar si el contenido del comentario está vacío
        if (comentario.getContenido().isEmpty()) {
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacío");
        }

        boolean respuestaPublicacion = fachadaPersistencia.existePublicacion(comentario.getPublicacionComun());
        // Validar si el contenido de la publicacion existe
        if (respuestaPublicacion == false) {
            throw new IllegalArgumentException("La publicación no existe");
        }

        // Validar si el usuario asociado al comentario existe en la base de datos
        boolean respuestaUsuario = fachadaPersistencia.existeUsuario(comentario.getUsuarioNormal().getAvatar(),
                comentario.getUsuarioNormal().getCredencial().getCorreo());
        if (respuestaUsuario == false) {
            throw new IllegalArgumentException("El usuario asociado al comentario no existe");
        }

        return fachadaPersistencia.registrarComentario(comentario);
    }

    @Override
    public boolean eliminarComentario(Comentario comentario) {
        return fachadaPersistencia.eliminarComentario(comentario);
    }

    @Override
    public List<Comentario> consultarComentarios() {
        return fachadaPersistencia.consultarComentarios();
    }

}
