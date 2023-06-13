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

/**
 *
 * @author HP
 */
public class PublicacionDAO implements IPublicacionDAO {

    private final IConexionBD CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Publicacion> COLECCION;

    public PublicacionDAO(IConexionBD CONEXION) {
        this.CONEXION = CONEXION;
        this.BASE_DATOS = CONEXION.getBaseDatos();
        this.COLECCION = BASE_DATOS.getCollection("publicaciones", Publicacion.class);
    }

    @Override
    public Comun registrarPublicacionComun(Comun publicacionComun) throws MongoDBException {
        try {
            List<String> errores = validarPublicacionComun(publicacionComun);
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
            List<String> errores = validarPublicacionAnclada(anclada);

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
            List<String> errores = validarPublicacionComun(publicacionComun);
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
            List<String> errores = validarPublicacion(publicacion);
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
            List<String> errores = validarPublicacion(publicacion);
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

    //Validaciones 
    private List<String> validarPublicacion(Publicacion publicacion) {
        List<String> errores = new ArrayList<>();

        // Validar los atributos de la publicación común
        if (publicacion.getFechaHoraCreacion() == null) {
            errores.add("El campo FechaHoraCreacion es requerido");
        }

        if (publicacion.getTitulo() == null || publicacion.getTitulo().isEmpty()) {
            errores.add("El campo Titulo es requerido");
        }

        if (publicacion.getContenido() == null || publicacion.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }

        return errores;
    }

    private List<String> validarPublicacionComun(Comun publicacionComun) {
        List<String> errores = new ArrayList<>();

        // Validar los atributos de la publicación común
        if (publicacionComun.getFechaHoraCreacion() == null) {
            errores.add("El campo FechaHoraCreacion es requerido");
        }

        if (publicacionComun.getTitulo() == null || publicacionComun.getTitulo().isEmpty()) {
            errores.add("El campo Titulo es requerido");
        }

        if (publicacionComun.getContenido() == null || publicacionComun.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }

        // Validar atributos específicos de la clase Comun
        if (publicacionComun.getUsuario() == null) {
            errores.add("El campo Usuario es requerido");
        }

        return errores;
    }

    private List<String> validarPublicacionAnclada(Anclada anclada) {
        List<String> errores = new ArrayList<>();

        // Validar los atributos de la publicación anclada
        if (anclada.getFechaHoraCreacion() == null) {
            errores.add("El campo FechaHoraCreacion es requerido");
        }

        if (anclada.getTitulo() == null || anclada.getTitulo().isEmpty()) {
            errores.add("El campo Titulo es requerido");
        }

        if (anclada.getContenido() == null || anclada.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }

        // Validar atributos específicos de la clase Anclada
        if (anclada.getAdmin() == null) {
            errores.add("El campo Admin es requerido");
        }

        return errores;
    }

}
