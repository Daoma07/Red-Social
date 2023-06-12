/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dominio.Ancalada;
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
public class Fachada implements IFachada {

    private final IComentarioDAO comentarioDAO;
    private final IPublicacionDAO publicacionDAO;
    private final IUsuarioDAO usuarioDAO;

    public Fachada() {
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
    public Ancalada registrarPublicacionAnclada(Ancalada anclada) {
        return publicacionDAO.registrarPublicacionAnclada(anclada);
    }

    @Override
    public Normal editarPublicacionNormal(Normal publicacionNormal) {
        return publicacionDAO.editarPublicacionNormal(publicacionNormal);
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
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioDAO.registrarUsuario(usuario);
    }

}
