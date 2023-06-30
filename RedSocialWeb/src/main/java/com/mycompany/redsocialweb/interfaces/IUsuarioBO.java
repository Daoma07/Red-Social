/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redsocialweb.interfaces;

import com.mycompany.redsocialweb.Exception.NegocioException;
import dominio.Usuario;
import excepciones.MongoDBException;

/**
 *
 * @author HP
 */
public interface IUsuarioBO {

    /**
     * Registra un usuario en la base de datos.
     *
     * @param usuario el usuario a registrar
     * @return el usuario registrado
     * @throws MongoDBException si se produce un error al registrar el usuario
     */
    public Usuario registrarUsuario(Usuario usuario) throws NegocioException;

    /**
     * Busca un usuario por su correo y contraseña.
     *
     * @param correo El correo del usuario a buscar.
     * @param contrasenia La contraseña del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra ningún usuario
     * con las credenciales proporcionadas.
     */
    public Usuario buscarUsuarioPorCredenciales(String correo, String contrasenia) throws NegocioException;
}
