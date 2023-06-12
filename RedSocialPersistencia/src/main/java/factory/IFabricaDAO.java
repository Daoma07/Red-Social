/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import interfaces.IComentarioDAO;
import interfaces.IPublicacionDAO;
import interfaces.IUsuarioDAO;

/**
 *
 * @author HP
 */
public interface IFabricaDAO {

    public IComentarioDAO crearComentarioDAO();

    public IPublicacionDAO crearPublicacionDAO();

    public IUsuarioDAO crearUsuarioDAO();
}
