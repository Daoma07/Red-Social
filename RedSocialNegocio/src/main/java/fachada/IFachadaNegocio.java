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
import java.util.List;

/**
 *
 * @author HP
 */
public interface IFachadaNegocio {

    //Comentario
    public Comentario registrarComentario(Comentario comentario);

    public boolean eliminarComentario(Comentario comentario);

    public List<Comentario> consultarComentarios();

    //Publicacion
    public Comun registrarPublicacionComun(Comun publicacionComun);

    public Anclada registrarPublicacionAnclada(Ancalada anclada);

    public Comun editarPublicacionComun(Comun publicacionComun);

    public List<Publicacion> consultarPublicaciones();

    public boolean eliminarPublicacion(Publicacion publicacion);

    public boolean existePublicacion(Publicacion publicacion);

    //Usuario
    public Usuario registrarUsuario(Usuario usuario);
}
