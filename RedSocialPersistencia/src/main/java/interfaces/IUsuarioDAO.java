/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Usuario;
import excepciones.MongoDBException;

/**
 *
 * @author HP
 */
public interface IUsuarioDAO {

    public Usuario registrarUsuario(Usuario usuario) throws MongoDBException;

    public boolean existeUsuario(String avatar, String correo) throws MongoDBException;

}
