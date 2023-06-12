/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Anclada;
import dominio.Comun;
import dominio.Publicacion;
import fachada.IFachadaPersistencia;
import interfaces.IPublicacionNegocio;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author HP
 */
public class PublicacionNegocio implements IPublicacionNegocio {

    private final IFachadaPersistencia fachadaPersistencia;

    public PublicacionNegocio(IFachadaPersistencia fachadaPersistencia) {
        this.fachadaPersistencia = fachadaPersistencia;
    }

    @Override
    public Comun registrarPublicacionComun(Comun publicacionComun) {
        if (publicacionComun == null) {
            throw new IllegalArgumentException("La publicacion no puede ser nula");
        }

        if (publicacionComun.getFechaHoraCreacion() == null) {
            publicacionComun.setFechaHoraCreacion(Calendar.getInstance());
        }

        if (publicacionComun.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El titulo de la publicación no puede estar vacío");
        }

        if (publicacionComun.getContenido().isEmpty()) {
            throw new IllegalArgumentException("El contenido de la publicación no puede estar vacío");
        }

        // Validar si el usuario asociado al comentario existe en la base de datos
        boolean respuestaUsuario = fachadaPersistencia.existeUsuario(
                publicacionComun.getUsuario().getAvatar(),
                publicacionComun.getUsuario().getCredencial().getCorreo());
        if (respuestaUsuario == false) {
            throw new IllegalArgumentException("El usuario asociado a la publicación no existe");
        }
        return fachadaPersistencia.registrarPublicacionComun(publicacionComun);
    }

    @Override
    public Anclada registrarPublicacionAnclada(Anclada anclada) {
        if (anclada == null) {
            throw new IllegalArgumentException("La publicacion anclada no puede ser nula");
        }

        if (anclada.getFechaHoraCreacion() == null) {
            anclada.setFechaHoraCreacion(Calendar.getInstance());
        }

        if (anclada.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El titulo de la publicación no puede estar vacío");
        }

        if (anclada.getContenido().isEmpty()) {
            throw new IllegalArgumentException("El contenido de la publicación no puede estar vacío");
        }

        // Validar si el usuario asociado al comentario existe en la base de datos
        boolean respuestaUsuario = fachadaPersistencia.existeUsuario(
                anclada.getAdministrador().getAvatar(),
                anclada.getAdministrador().getCredencial().getCorreo());
        if (respuestaUsuario == false) {
            throw new IllegalArgumentException("El usuario asociado a la publicación no existe");
        }
        return fachadaPersistencia.registrarPublicacionAnclada(anclada);
    }

    @Override
    public Comun editarPublicacionComun(Comun publicacionComun) {
        if (publicacionComun.getUsuario() == null) {
            throw new IllegalArgumentException("El usuario asociado a la publicación no existe");
        }

        return fachadaPersistencia.editarPublicacionComun(publicacionComun);
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        return fachadaPersistencia.consultarPublicaciones();
    }

    @Override
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return fachadaPersistencia.eliminarPublicacion(publicacion);
    }

    @Override
    public boolean existePublicacion(Publicacion publicacion) {
        return fachadaPersistencia.existePublicacion(publicacion);
    }

}
