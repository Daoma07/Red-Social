/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redsocialweb.implementacion;

import com.mycompany.redsocialweb.Exception.NegocioException;
import com.mycompany.redsocialweb.interfaces.IUsuarioBO;
import dominio.Usuario;
import excepciones.MongoDBException;
import fachada.FachadaPersistencia;

/**
 *
 * @author HP
 */
public class UsuarioBO implements IUsuarioBO {

    FachadaPersistencia fachadaPersistencia;

    public UsuarioBO() {
        this.fachadaPersistencia = new FachadaPersistencia();
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws NegocioException {
        return fachadaPersistencia.registrarUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorCredenciales(String correo, String contrasenia) throws NegocioException {
        return fachadaPersistencia.buscarUsuarioPorCredenciales(correo, contrasenia);
    }

}
