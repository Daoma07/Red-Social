
package daos;

import baseDatos.IConexionBD;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import dominio.Anclada;
import dominio.Comun;
import dominio.Publicacion;
import excepciones.MongoDBException;
import interfaces.IPublicacionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import validaciones.PublicacionValidacion;

/**
 *
 * @author Daniel Omar Alameda, Mario Alejandro Salcedo, David Sotelo Palafox
 */
public class PublicacionDAO implements IPublicacionDAO {

    private final IConexionBD CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Publicacion> COLECCION;
    private PublicacionValidacion publicacionValidacion;

    /**
     * Constructor de la clase PublicacionDAO.
     *
     * @param CONEXION La instancia de IConexionBD utilizada para establecer la
     * conexión con la base de datos.
     */
    public PublicacionDAO(IConexionBD CONEXION) {
        this.CONEXION = CONEXION;
        this.BASE_DATOS = CONEXION.getBaseDatos();
        this.COLECCION = BASE_DATOS.getCollection("publicaciones", Publicacion.class);
        this.publicacionValidacion = new PublicacionValidacion();
    }

    /**
     * Registra una publicación común en la base de datos.
     *
     * @param publicacionComun La publicación común a registrar.
     * @return La publicación común registrada, o null si ocurrió un error.
     */
    @Override
    public Comun registrarPublicacionComun(Comun publicacionComun) throws MongoDBException {
        try {
            List<String> errores = publicacionValidacion.validarPublicacionComun(publicacionComun);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La publicación común no es válida: " + mensajeError);
            }
            COLECCION.insertOne(publicacionComun);
            System.out.println("Publicación registrada exitosamente");
            return publicacionComun;
        } catch (MongoDBException e) {
            System.out.println("Error al registrar la publicación comun: " + e.getMessage());
            return null;
        }
    }

    /**
     * Registra una publicación anclada en la base de datos.
     *
     * @param anclada La publicación anclada a registrar.
     * @return La publicación anclada registrada, o null si ocurrió un error.
     */
    @Override
    public Anclada registrarPublicacionAnclada(Anclada anclada) throws MongoDBException {
        try {
            List<String> errores = publicacionValidacion.validarPublicacionAnclada(anclada);

            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La publicación anclada no es válida: " + mensajeError);
            }
            COLECCION.insertOne(anclada);
            System.out.println("Publicación registrada exitosamente");
            return anclada;
        } catch (MongoDBException e) {
            System.out.println("Error al registrar la publicación }{ñljk.anclada0-: " + e.getMessage());
            return null;
        }
    }

    /**
     * Edita una publicación común en la base de datos.
     *
     * @param publicacionComun La publicación común a editar.
     * @return La publicación común editada, o null si ocurrió un error o la
     * publicación no se encontró.
     */
    @Override
    public Comun editarPublicacionComun(Comun publicacionComun) throws MongoDBException {
        try {
            List<String> errores = publicacionValidacion.validarPublicacionComun(publicacionComun);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La publicación común no es válida: " + mensajeError);
            }
            ObjectId publicacionId = publicacionComun.getId();
            Bson filtro = Filters.eq("_id", publicacionId);
            Bson update = new Document("$set", publicacionComun);
            UpdateResult resultado = COLECCION.updateOne(filtro, update);

            if (resultado.getModifiedCount() > 0) {
                System.out.println("Publicación comun editada exitosamente");
                return publicacionComun;
            } else {
                System.out.println("No se encontró la publicación comun para editar");
                return null;
            }
        } catch (MongoDBException e) {
            System.out.println("Error al editar la publicación comun: " + e.getMessage());
            return null;
        }
    }

    /**
     * Consulta todas las publicaciones en la base de datos.
     *
     * @return Una lista de publicaciones.
     */
    @Override
    public List<Publicacion> consultarPublicaciones() throws MongoDBException {
        try {
            List<Publicacion> publicaciones = new ArrayList<>();
            MongoCursor<Publicacion> cursor = COLECCION.find().iterator();
            while (cursor.hasNext()) {
                Publicacion publicacion = cursor.next();
                publicaciones.add(publicacion);
            }
            cursor.close();
            return publicaciones;
        } catch (MongoDBException e) {
            System.out.println("Error al consultar las publicaciones: " + e.getMessage());
            return null;
        }
    }

    /**
     * Elimina una publicación de la base de datos.
     *
     * @param publicacion La publicación a eliminar.
     * @return true si la eliminación fue exitosa, false si ocurrió un error o
     * la publicación no se encontró.
     */
    @Override
    public boolean eliminarPublicacion(Publicacion publicacion) throws MongoDBException {
        try {
            List<String> errores = publicacionValidacion.validarPublicacion(publicacion);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La publicación no es válida: " + mensajeError);
            }
            ObjectId publicacionId = publicacion.getId();
            Bson filtro = Filters.eq("_id", publicacionId);
            DeleteResult resultado = COLECCION.deleteOne(filtro);

            if (resultado.getDeletedCount() > 0) {
                System.out.println("Publicación eliminada exitosamente");
                return true;
            } else {
                System.out.println("No se encontró la publicación para eliminar");
                return false;
            }
        } catch (MongoDBException e) {
            System.out.println("Error al eliminar la publicación: " + e.getMessage());
            return false;
        }
    }

    /**
     * Verifica si una publicación existe en la base de datos.
     *
     * @param publicacion La publicación a verificar.
     * @return true si la publicación existe, false si no existe o si ocurrió un
     * error.
     */
    @Override
    public boolean existePublicacion(Publicacion publicacion) throws MongoDBException {
        try {
            List<String> errores = publicacionValidacion.validarPublicacion(publicacion);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La publicación no es válida: " + mensajeError);
            }
            ObjectId publicacionId = publicacion.getId();
            Bson filtro = Filters.eq("_id", publicacionId);
            long count = COLECCION.countDocuments(filtro);
            return count > 0;
        } catch (MongoDBException e) {
            System.out.println("Error al verificar la existencia de la publicación: " + e.getMessage());
            return false;
        }
    }
}
