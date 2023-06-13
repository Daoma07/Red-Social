/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Usuario;
import excepciones.MongoDBException;

/**
 * Esta interfaz define los métodos para realizar operaciones relacionadas con los usuarios en la base de datos.
 */
public interface IUsuarioDAO {

    /**
     * Registra un usuario en la base de datos.
     *
     * @param usuario el usuario a registrar
     * @return el usuario registrado
     * @throws MongoDBException si se produce un error al registrar el usuario
     */
    public Usuario registrarUsuario(Usuario usuario) throws MongoDBException;

    /**
     * Verifica la existencia de un usuario en la base de datos.
     *
     * @param avatar el avatar del usuario
     * @param correo el correo electrónico del usuario
     * @return true si el usuario existe, false si no existe
     * @throws MongoDBException si se produce un error al verificar la existencia del usuario
     */
    public boolean existeUsuario(String avatar, String correo) throws MongoDBException;

}
