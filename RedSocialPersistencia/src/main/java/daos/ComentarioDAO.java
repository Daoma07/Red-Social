/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import baseDatos.IConexionBD;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import dominio.Comentario;
import excepciones.MongoDBException;
import interfaces.IComentarioDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author HP
 */
public class ComentarioDAO implements IComentarioDAO {

    private final IConexionBD CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Comentario> COLECCION;

    public ComentarioDAO(IConexionBD CONEXION) {
        this.CONEXION = CONEXION;
        this.BASE_DATOS = CONEXION.getBaseDatos();
        this.COLECCION = BASE_DATOS.getCollection("comentarios", Comentario.class);
    }

    @Override
    public Comentario registrarComentario(Comentario comentario) throws MongoDBException {
        try {
            COLECCION.insertOne(comentario);
            return comentario;
        } catch (MongoDBException e) {
            System.out.println("Error al registrar el comentario: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean eliminarComentario(Comentario comentario) {
        try {
            ObjectId comentarioId = comentario.getId();
            COLECCION.deleteOne(eq("_id", comentarioId));
            System.out.println("Comentario eliminado exitosamente");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el comentario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Comentario> consultarComentarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
