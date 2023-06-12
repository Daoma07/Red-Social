/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Anclada;
import dominio.Comun;
import dominio.Publicacion;
import excepciones.MongoDBException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IPublicacionDAO {

    public Comun registrarPublicacionComun(Comun publicacionComun) throws MongoDBException;

    public Anclada registrarPublicacionAnclada(Anclada anclada) throws MongoDBException;

    public Comun editarPublicacionComun(Comun publicacionComun) throws MongoDBException;

    public List<Publicacion> consultarPublicaciones() throws MongoDBException;

    public boolean eliminarPublicacion(Publicacion publicacion) throws MongoDBException;

    public boolean existePublicacion(Publicacion publicacion) throws MongoDBException;

}
