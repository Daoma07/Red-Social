/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dominio.Anclada;
import dominio.Comentario;
import dominio.Comun;
import dominio.Publicacion;
import dominio.Usuario;
import factory.FabricaNegocio;
import factory.IFabricaNegocio;
import interfaces.IComentarioNegocio;
import interfaces.IPublicacionNegocio;
import interfaces.IUsuarioNegocio;
import java.util.List;

/**
 *
 * @author HP
 */
public class FachadaNegocio implements IFachadaNegocio {

    private final IComentarioNegocio comentarioNegocio;
    private final IPublicacionNegocio publicacionNegocio;
    private final IUsuarioNegocio usuarioNegocio;

    public FachadaNegocio() {
        IFabricaNegocio fabricaNegocio = new FabricaNegocio();
        this.comentarioNegocio = fabricaNegocio.crearComentarioNegocio();
        this.publicacionNegocio = fabricaNegocio.crearPublicacionNegocio();
        this.usuarioNegocio = fabricaNegocio.crearUsuarioNegocio();
    }

    @Override
    public Comentario registrarComentario(Comentario comentario) {
        return comentarioNegocio.registrarComentario(comentario);
    }

    @Override
    public boolean eliminarComentario(Comentario comentario) {
        return comentarioNegocio.eliminarComentario(comentario);
    }

    @Override
    public List<Comentario> consultarComentarios() {
        return comentarioNegocio.consultarComentarios();
    }

    @Override
    public Comun registrarPublicacionComun(Comun publicacionComun) {
        return publicacionNegocio.registrarPublicacionComun(publicacionComun);
    }

    @Override
    public Anclada registrarPublicacionAnclada(Anclada anclada) {
        return publicacionNegocio.registrarPublicacionAnclada(anclada);
    }

    @Override
    public Comun editarPublicacionComun(Comun publicacionComun) {
        return publicacionNegocio.editarPublicacionComun(publicacionComun);
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        return publicacionNegocio.consultarPublicaciones();
    }

    @Override
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return publicacionNegocio.eliminarPublicacion(publicacion);
    }

    @Override
    public boolean existePublicacion(Publicacion publicacion) {
        return publicacionNegocio.existePublicacion(publicacion);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioNegocio.registrarUsuario(usuario);
    }

}
