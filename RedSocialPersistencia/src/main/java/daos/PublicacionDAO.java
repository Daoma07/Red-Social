/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author HP
 */
public class PublicacionDAO implements IPublicacionDAO {

    private final IConexionBD CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Publicacion> COLECCION;
    private PublicacionValidacion publicacionValidacion;

    public PublicacionDAO(IConexionBD CONEXION) {
        this.CONEXION = CONEXION;
        this.BASE_DATOS = CONEXION.getBaseDatos();
        this.COLECCION = BASE_DATOS.getCollection("publicaciones", Publicacion.class);
        this.publicacionValidacion = new PublicacionValidacion();
    }

    @Override
    public Comun registrarPublicacionComun(Comun publicacionComun) throws MongoDBException {
        try {
            List<String> errores = publicacionValidacion.validarPublicacionComun(publicacionComun);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La publicación común no es válida: " + mensajeError);
            }
            COLECCION.insertOne(publicacionComun);
            return publicacionComun;
        } catch (MongoDBException e) {
            System.out.println("Error al registrar la publicación comun: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Anclada registrarPublicacionAnclada(Anclada anclada) throws MongoDBException {
        try {
            List<String> errores = publicacionValidacion.validarPublicacionAnclada(anclada);

            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La publicación anclada no es válida: " + mensajeError);
            }
            COLECCION.insertOne(anclada);
            return anclada;
        } catch (MongoDBException e) {
            System.out.println("Error al registrar la publicación }{ñljk.anclada0-: " + e.getMessage());
            return null;
        }
    }

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
