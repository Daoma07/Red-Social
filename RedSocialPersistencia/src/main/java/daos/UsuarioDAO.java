/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import baseDatos.IConexionBD;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.Usuario;
import excepciones.MongoDBException;
import interfaces.IUsuarioDAO;
import java.util.List;
import org.bson.Document;
import validaciones.UsuarioValidacion;

/**
 *
 * @author HP
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final IConexionBD CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Usuario> COLECCION;
    private UsuarioValidacion usuarioValidacion;

    /**
    * Constructor de la clase UsuarioDAO.
    *
    * @param CONEXION La instancia de IConexionBD utilizada para establecer la conexión con la base de datos.
    */
    public UsuarioDAO(IConexionBD CONEXION) {
        this.CONEXION = CONEXION;
        this.BASE_DATOS = CONEXION.getBaseDatos();
        this.COLECCION = BASE_DATOS.getCollection("usuarios", Usuario.class);
        this.usuarioValidacion = new UsuarioValidacion();
    }

    /**
    * Registra un usuario en la base de datos.
    *
    * @param usuario El usuario a registrar.
    * @return El usuario registrado, o null si ocurrió un error o el avatar o correo electrónico ya están en uso.
    */
    @Override
    public Usuario registrarUsuario(Usuario usuario) throws MongoDBException {
        try {
            List<String> errores = usuarioValidacion.validarUsuario(usuario);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La Usuario no es válido: " + mensajeError);
            }
            if (!existeUsuario(usuario.getAvatar(), usuario.getCredencial().getCorreo())) {
                COLECCION.insertOne(usuario);
                System.out.println("Usuario registrado exitosamente");
                return usuario;
            } else {
                System.out.println("El avatar o correo electrónico ya están en uso");
                throw new MongoDBException("El avatar o correo electrónico ya están en uso");
            }
        } catch (MongoDBException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return null;
        }
    }

    /**
    * Verifica si existe un usuario con el avatar o correo electrónico dado en la base de datos.
    *
    * @param avatar El avatar del usuario a verificar.
    * @param correo El correo electrónico del usuario a verificar.
    * @return true si existe un usuario con el avatar o correo electrónico dado, false de lo contrario.
    */
    @Override
    public boolean existeUsuario(String avatar, String correo) throws MongoDBException {
        try {
            List<String> errores = usuarioValidacion.validarExistencia(avatar, correo);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("Los Datos no son validos: " + mensajeError);
            }
            Document filtro = new Document("$or",
                    new Document[]{
                        new Document("avatar", avatar),
                        new Document("credencial.correo", correo)
                    }
            );
            return COLECCION.countDocuments(filtro) > 0;
        } catch (MongoDBException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return false;
        }
    }

}
