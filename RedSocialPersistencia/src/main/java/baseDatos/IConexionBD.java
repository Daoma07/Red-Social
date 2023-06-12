/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import com.mongodb.client.MongoDatabase;

/**
 * /**
 * Interfaz para la conexión a la base de datos
 */
public interface IConexionBD {

    /**
     * Devuelve una conexión a la base de datos en Mongo
     *
     * @return Conexión
     */
    public MongoDatabase getBaseDatos();
}
