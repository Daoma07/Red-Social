
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
 * @author Daniel Omar Alameda, Mario Alejandro Salcedo, David Sotelo Palafox
 */
public class FachadaPersistencia implements IFachadaPersistencia {

    private final IComentarioDAO comentarioDAO;
    private final IPublicacionDAO publicacionDAO;
    private final IUsuarioDAO usuarioDAO;

    /**
     * Crea una instancia de la clase FachadaPersistencia. Inicializa los DAO
     * necesarios utilizando una fábrica de DAO.
     */
    public FachadaPersistencia() {
        IFabricaDAO fabricaDAO = new FabricaDAO();
        this.comentarioDAO = fabricaDAO.crearComentarioDAO();
        this.publicacionDAO = fabricaDAO.crearPublicacionDAO();
        this.usuarioDAO = fabricaDAO.crearUsuarioDAO();
    }

    /**
     * Registra un comentario en la base de datos.
     *
     * @param comentario el comentario a registrar
     * @return el comentario registrado, o null si ocurre un error
     */
    @Override
    public Comentario registrarComentario(Comentario comentario) {
        return comentarioDAO.registrarComentario(comentario);
    }

    /**
     * Elimina un comentario de la base de datos.
     *
     * @param comentario el comentario a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    @Override
    public boolean eliminarComentario(Comentario comentario) {
        return comentarioDAO.eliminarComentario(comentario);
    }

    /**
     * Consulta todos los comentarios almacenados en la base de datos.
     *
     * @return una lista de comentarios, o null si ocurre un error
     */
    @Override
    public List<Comentario> consultarComentarios() {
        return comentarioDAO.consultarComentarios();
    }

    /**
     * Registra una publicación común en la base de datos.
     *
     * @param publicacionComun la publicación común a registrar
     * @return la publicación común registrada, o null si ocurre un error
     */
    @Override
    public Comun registrarPublicacionComun(Comun publicacionComun) {
        return publicacionDAO.registrarPublicacionComun(publicacionComun);
    }

    /**
     * Registra una publicación anclada en la base de datos.
     *
     * @param anclada la publicación anclada a registrar
     * @return la publicación anclada registrada, o null si ocurre un error
     */
    @Override
    public Anclada registrarPublicacionAnclada(Anclada anclada) {
        return publicacionDAO.registrarPublicacionAnclada(anclada);
    }

    /**
     * Edita una publicación común en la base de datos.
     *
     * @param publicacionComun la publicación común a editar
     * @return la publicación común editada, o null si ocurre un error
     */
    @Override
    public Comun editarPublicacionComun(Comun publicacionComun) {
        return publicacionDAO.editarPublicacionComun(publicacionComun);
    }

    /**
     * Consulta todas las publicaciones almacenadas en la base de datos.
     *
     * @return una lista de publicaciones, o null si ocurre un error
     */
    @Override
    public List<Publicacion> consultarPublicaciones() {
        return publicacionDAO.consultarPublicaciones();
    }

    /**
     * Elimina una publicación de la base de datos.
     *
     * @param publicacion la publicación a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    @Override
    public boolean eliminarPublicacion(Publicacion publicacion) {
        return publicacionDAO.eliminarPublicacion(publicacion);
    }

    /**
     * Verifica la existencia de una publicación en la base de datos.
     *
     * @param publicacion la publicación a verificar
     * @return true si la publicación existe, false en caso contrario
     */
    @Override
    public boolean existePublicacion(Publicacion publicacion) {
        return publicacionDAO.existePublicacion(publicacion);
    }

    /**
     * Registra un usuario en la base de datos.
     *
     * @param usuario el usuario a registrar
     * @return el usuario registrado, o null si ocurre un error
     */
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioDAO.registrarUsuario(usuario);
    }

    /**
     * Verifica la existencia de un usuario en la base de datos.
     *
     * @param avatar el avatar del usuario
     * @param correo el correo electrónico del usuario
     * @return true si el usuario existe, false en caso contrario
     */
    @Override
    public boolean existeUsuario(String avatar, String correo) {
        return usuarioDAO.existeUsuario(avatar, correo);
    }

}
