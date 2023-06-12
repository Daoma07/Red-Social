/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import baseDatos.ConexionMongoDB;
import baseDatos.IConexionBD;
import interfaces.IComentarioDAO;
import interfaces.IPublicacionDAO;
import interfaces.IUsuarioDAO;
import daos.ComentarioDAO;
import daos.PublicacionDAO;
import daos.UsuarioDAO;

/**
 *
 * @author HP
 */
public class FabricaDAO implements IFabricaDAO {

    private IConexionBD conexion;

    public FabricaDAO() {
        this.conexion = new ConexionMongoDB();
    }

    @Override
    public IComentarioDAO crearComentarioDAO() {
        return new ComentarioDAO(conexion);
    }

    @Override
    public IPublicacionDAO crearPublicacionDAO() {
        return new PublicacionDAO(conexion);
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO() {
        return new UsuarioDAO(conexion);
    }

}
