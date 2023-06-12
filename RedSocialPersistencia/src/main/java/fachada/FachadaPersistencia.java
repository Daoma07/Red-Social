/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dominio.Anclada;
import dominio.Comentario;
import dominio.Comun;
import dominio.Normal;
import dominio.Publicacion;
import dominio.Usuario;
import factory.FabricaDAO;
import factory.IFabricaDAO;
import interfaces.IComentarioDAO;
import interfaces.IPublicacionDAO;
import interfaces.IUsuarioDAO;
import java.util.List;

/**
 *
 * @author HP
 */
public class FachadaPersistencia implements IFachadaPersistencia {

    private final IComentarioDAO comentarioDAO;
    private final IPublicacionDAO publicacionDAO;
    private final IUsuarioDAO usuarioDAO;

    public FachadaPersistencia() {
        IFabricaDAO fabricaDAO = new FabricaDAO();
        this.comentarioDAO = fabricaDAO.crearComentarioDAO();
        this.publicacionDAO = fabricaDAO.crearPublicacionDAO();
        this.usuarioDAO = fabricaDAO.crearUsuarioDAO();
    }

    @Override
    public Comentario registrarComentario(Comentario comentario) {
        return comentarioDAO.registrarComentario(comentario);
    }

    @Override
    public boolean eliminarComentario(Comentario comentario) {
        return comentarioDAO.eliminarComentario(comentario);
    }

    @Override
    public List<Comentario> consultarComentarios() {
        return comentarioDAO.consultarComentarios();
    }

    @Override
    public Comun registrarPublicacionComun(Comun publicacionComun) {
        return publicacionDAO.registrarPublicacionComun(publicacionComun);
    }

    @Override
    public Anclada registrarPublicacionAnclada(Anclada anclada) {
        return publicacionDAO.registrarPublicacionAnclada(anclada);
    }

    @Override
    public Comun editarPublicacionComun(Comun publicacionComun) {
        return publicacionDAO.editarPublicacionComun(publicacionComun);
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        return publicacionDAO.consultarPublicaciones();
    }

    @Override
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return publicacionDAO.eliminarPublicacion(publicacion);
    }

    @Override
    public boolean existePublicacion(Publicacion publicacion) {
        return publicacionDAO.existePublicacion(publicacion);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioDAO.registrarUsuario(usuario);
    }

    @Override
    public boolean existeUsuario(String avatar, String correo) {
        return usuarioDAO.existeUsuario(avatar, correo);
    }

}
