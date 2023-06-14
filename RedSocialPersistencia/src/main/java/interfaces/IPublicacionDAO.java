
package interfaces;

import dominio.Anclada;
import dominio.Comun;
import dominio.Publicacion;
import excepciones.MongoDBException;
import java.util.List;

/**
 * Esta interfaz define los métodos para realizar operaciones relacionadas con las publicaciones en la base de datos.
 */
public interface IPublicacionDAO {

    /**
     * Registra una publicación común en la base de datos.
     *
     * @param publicacionComun la publicación común a registrar
     * @return la publicación común registrada
     * @throws MongoDBException si se produce un error al registrar la publicación común
     */
    public Comun registrarPublicacionComun(Comun publicacionComun) throws MongoDBException;

    /**
     * Registra una publicación anclada en la base de datos.
     *
     * @param anclada la publicación anclada a registrar
     * @return la publicación anclada registrada
     * @throws MongoDBException si se produce un error al registrar la publicación anclada
     */
    public Anclada registrarPublicacionAnclada(Anclada anclada) throws MongoDBException;

    /**
     * Edita una publicación común en la base de datos.
     *
     * @param publicacionComun la publicación común a editar
     * @return la publicación común editada
     * @throws MongoDBException si se produce un error al editar la publicación común
     */
    public Comun editarPublicacionComun(Comun publicacionComun) throws MongoDBException;

    /**
     * Consulta todas las publicaciones almacenadas en la base de datos.
     *
     * @return una lista de publicaciones
     * @throws MongoDBException si se produce un error al consultar las publicaciones
     */
    public List<Publicacion> consultarPublicaciones() throws MongoDBException;

    /**
     * Elimina una publicación de la base de datos.
     *
     * @param publicacion la publicación a eliminar
     * @return true si se elimina la publicación correctamente, false si no se encuentra la publicación o se produce un error al eliminarla
     * @throws MongoDBException si se produce un error al eliminar la publicación
     */
    public boolean eliminarPublicacion(Publicacion publicacion) throws MongoDBException;

    /**
     * Verifica la existencia de una publicación en la base de datos.
     *
     * @param publicacion la publicación a verificar
     * @return true si la publicación existe, false si no existe o se produce un error al verificarla
     * @throws MongoDBException si se produce un error al verificar la existencia de la publicación
     */
    public boolean existePublicacion(Publicacion publicacion) throws MongoDBException;

}

