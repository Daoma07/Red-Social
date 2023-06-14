
package fachada;

import dominio.Anclada;
import dominio.Comentario;
import dominio.Comun;
import dominio.Normal;
import dominio.Publicacion;
import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Daniel Omar Alameda, Mario Alejandro Salcedo, David Sotelo Palafox
 */
public interface IFachadaPersistencia {

    //Comentarios
    /**
     * Registra un comentario en la base de datos.
     * @param comentario El comentario a registrar.
     * @return El comentario registrado.
     */
    
    public Comentario registrarComentario(Comentario comentario);

    /**
     * Elimina un comentario de la base de datos.
     * @param comentario El comentario a eliminar.
     * @return `true` si se elimina correctamente, `false` en caso contrario.
     */
    
    public boolean eliminarComentario(Comentario comentario);

    /**
     * Consulta todos los comentarios almacenados en la base de datos.
     * @return Una lista de comentarios.
     */
    
    public List<Comentario> consultarComentarios();

    //Publicación
    /**
     * Registra una publicación común en la base de datos.
     * @param publicacionComun La publicación común a registrar.
     * @return La publicación común registrada.
     */
    
    public Comun registrarPublicacionComun(Comun publicacionComun);

    /**
     * Registra una publicación anclada en la base de datos.
     * @param anclada La publicación anclada a registrar.
     * @return La publicación anclada registrada.
     */
    
    public Anclada registrarPublicacionAnclada(Anclada anclada);

    /**
     * Edita una publicación común en la base de datos.
     * @param publicacionComun La publicación común a editar.
     * @return La publicación común editada.
     */
    
    public Comun editarPublicacionComun(Comun publicacionComun);

    /**
     * Consulta todas las publicaciones almacenadas en la base de datos.
     * @return Una lista de publicaciones.
     */
    public List<Publicacion> consultarPublicaciones();

    /**
     * Elimina una publicación de la base de datos.
     * @param publicacion La publicación a eliminar.
     * @return `true` si se elimina correctamente, `false` en caso contrario.
     */
    public boolean eliminarPublicacion(Publicacion publicacion);

    /**
     * Verifica la existencia de una publicación en la base de datos.
     * @param publicacion La publicación a verificar.
     * @return `true` si la publicación existe, `false` en caso contrario.
     */
    public boolean existePublicacion(Publicacion publicacion);

    //Usuario
    /**
     * Registra un usuario en la base de datos.
     * @param usuario El usuario a registrar.
     * @return El usuario registrado.
     */
    public Usuario registrarUsuario(Usuario usuario);

    /**
     * Verifica la existencia de un usuario en la base de datos.
     * @param avatar El avatar del usuario.
     * @param correo El correo electrónico del usuario.
     * @return `true` si el usuario existe, `false` en caso contrario.
     */
    public boolean existeUsuario(String avatar, String correo);

}