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
import dominio.Ancalada;
import dominio.Comun;
import dominio.Normal;
import dominio.Publicacion;
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
    public Comun registrarPublicacionComun(Comun publicacionComun) {
        try {
            COLECCION.insertOne(publicacionComun);
            return publicacionComun;
        } catch (Exception e) {
            System.out.println("Error al registrar la publicación comun: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Ancalada registrarPublicacionAnclada(Ancalada anclada) {
        try {
            COLECCION.insertOne(anclada);
            return anclada;
        } catch (Exception e) {
            System.out.println("Error al registrar la publicación }{ñljk.anclada0-: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Normal editarPublicacionNormal(Normal publicacionNormal) {
        try {
            ObjectId publicacionId = publicacionNormal.getId();
            Bson filtro = Filters.eq("_id", publicacionId);
            Bson update = new Document("$set", publicacionNormal);
            UpdateResult resultado = COLECCION.updateOne(filtro, update);

            if (resultado.getModifiedCount() > 0) {
                System.out.println("Publicación normal editada exitosamente");
                return publicacionNormal;
            } else {
                System.out.println("No se encontró la publicación normal para editar");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al editar la publicación normal: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        try {
            List<Publicacion> publicaciones = new ArrayList<>();
            MongoCursor<Publicacion> cursor = COLECCION.find().iterator();
            while (cursor.hasNext()) {
                Publicacion publicacion = cursor.next();
                publicaciones.add(publicacion);
            }
            cursor.close();
            return publicaciones;
        } catch (Exception e) {
            System.out.println("Error al consultar las publicaciones: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean eliminarPublicacion(Publicacion publicacion) {
        try {
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
        } catch (Exception e) {
            System.out.println("Error al eliminar la publicación: " + e.getMessage());
            return false;
        }
    }

}
