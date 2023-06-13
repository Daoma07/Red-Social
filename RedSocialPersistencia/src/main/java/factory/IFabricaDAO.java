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
 * Esta interfaz define los métodos para crear instancias de los DAO correspondientes.
 */
public interface IFabricaDAO {

    /**
     * Crea y devuelve una instancia de IComentarioDAO.
     *
     * @return una instancia de IComentarioDAO
     */
    public IComentarioDAO crearComentarioDAO();

    /**
     * Crea y devuelve una instancia de IPublicacionDAO.
     *
     * @return una instancia de IPublicacionDAO
     */
    public IPublicacionDAO crearPublicacionDAO();

    /**
     * Crea y devuelve una instancia de IUsuarioDAO.
     *
     * @return una instancia de IUsuarioDAO
     */
    public IUsuarioDAO crearUsuarioDAO();
    
}