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
import java.util.ArrayList;
import java.util.List;
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
    public Usuario registrarUsuario(Usuario usuario) throws MongoDBException {
        try {
            List<String> errores = validarUsuario(usuario);
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

    @Override
    public boolean existeUsuario(String avatar, String correo) throws MongoDBException {
        try {
            List<String> errores = validarExistencia(avatar, correo);
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

    //Validaciones
    private List<String> validarUsuario(Usuario usuario) {
        List<String> errores = new ArrayList<>();

        // Validar los atributos del usuario
        if (usuario.getNombres() == null || usuario.getNombres().isEmpty()) {
            errores.add("El campo Nombres es requerido");
        }

        if (usuario.getApellidoPaterno() == null || usuario.getApellidoPaterno().isEmpty()) {
            errores.add("El campo ApellidoPaterno es requerido");
        }

        if (usuario.getApellidoMaterno() == null || usuario.getApellidoMaterno().isEmpty()) {
            errores.add("El campo ApellidoMaterno es requerido");
        }

        if (usuario.getTelefono() == null || usuario.getTelefono().isEmpty()) {
            errores.add("El campo Telefono es requerido");
        }

        if (usuario.getAvatar() == null || usuario.getAvatar().isEmpty()) {
            errores.add("El campo Avatar es requerido");
        }

        if (usuario.getCiudad() == null || usuario.getCiudad().isEmpty()) {
            errores.add("El campo Ciudad es requerido");
        }

        if (usuario.getFechaNacimiento() == null) {
            errores.add("El campo FechaNacimiento es requerido");
        }

        if (usuario.getGenero() == null) {
            errores.add("El campo Genero es requerido");
        }

        if (usuario.getCredencial() == null) {
            errores.add("La credencial del usuario es inválida");
        }
        return errores;
    }

    private List<String> validarExistencia(String avatar, String correo) {
        List<String> errores = new ArrayList<>();

        if (avatar == null || avatar.isEmpty()) {
            errores.add("El Avatar es requerido");
        }

        if (correo == null || correo.isEmpty()) {
            errores.add("El Correo es requerido");
        }

        return errores;
    }
}
