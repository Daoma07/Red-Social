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
import interfaces.IUsuarioDAO;
import org.bson.Document;

/**
 *
 * @author HP
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final IConexionBD CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Usuario> COLECCION;

    public UsuarioDAO(IConexionBD CONEXION) {
        this.CONEXION = CONEXION;
        this.BASE_DATOS = CONEXION.getBaseDatos();
        this.COLECCION = BASE_DATOS.getCollection("usuarios", Usuario.class);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        try {
            if (!existeUsuario(usuario.getAvatar(), usuario.getCredencial().getCorreo())) {
                COLECCION.insertOne(usuario);
                System.out.println("Usuario registrado exitosamente.");
                return usuario;
            } else {
                System.out.println("El avatar o correo electrónico ya están en uso.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean existeUsuario(String avatar, String correo) {
        Document filtro = new Document("$or",
                new Document[]{
                    new Document("avatar", avatar),
                    new Document("credencial.correo", correo)
                }
        );

        return COLECCION.countDocuments(filtro) > 0;
    }

}
