/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redsocialweb.factory;

import com.mycompany.redsocialweb.interfaces.IUsuarioBO;
import interfaces.IComentarioDAO;

/**
 *
 * @author HP
 */
public interface IFabricaBO {

    /**
     * Crea y devuelve una instancia de IUsuarioBO
     *
     * @return una instancia de IUsuarioBO
     */
    public IUsuarioBO crearUsuarioBO();
}
