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
import java.util.List;

/**
 *
 * @author HP
 */
public interface IFachada {

    //Comentarios
    public Comentario registrarComentario(Comentario comentario);

    public boolean eliminarComentario(Comentario comentario);

    public List<Comentario> consultarComentarios();

    //Publicación
    public Comun registrarPublicacionComun(Comun publicacionComun);

    public Ancalada registrarPublicacionAnclada(Ancalada anclada);

    public Normal editarPublicacionNormal(Normal publicacionNormal);

    public List<Publicacion> consultarPublicaciones();

    public boolean eliminarPublicacion(Publicacion publicacion);

    //Usuario
    public Usuario registrarUsuario(Usuario usuario);

}
