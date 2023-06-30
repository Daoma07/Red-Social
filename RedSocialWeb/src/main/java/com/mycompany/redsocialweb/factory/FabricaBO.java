/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redsocialweb.factory;

import com.mycompany.redsocialweb.implementacion.UsuarioBO;
import com.mycompany.redsocialweb.interfaces.IUsuarioBO;

/**
 *
 * @author HP
 */
public class FabricaBO implements IFabricaBO {

    @Override
    public IUsuarioBO crearUsuarioBO() {
        return new UsuarioBO();
    }

}
