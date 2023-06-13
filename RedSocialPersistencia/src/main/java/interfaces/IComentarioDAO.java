/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Comentario;
import java.util.List;
import excepciones.MongoDBException;

/**
 * Esta interfaz define los métodos para realizar operaciones relacionadas con los comentarios en la base de datos.
 */
public interface IComentarioDAO {

    /**
     * Registra un comentario en la base de datos.
     *
     * @param comentario el comentario a registrar
     * @return el comentario registrado
     * @throws MongoDBException si se produce un error al registrar el comentario
     */
    public Comentario registrarComentario(Comentario comentario) throws MongoDBException;

    /**
     * Elimina un comentario de la base de datos.
     *
     * @param comentario el comentario a eliminar
     * @return true si se elimina el comentario correctamente, false si no se encuentra el comentario o se produce un error al eliminarlo
     * @throws MongoDBException si se produce un error al eliminar el comentario
     */
    public boolean eliminarComentario(Comentario comentario) throws MongoDBException;

    /**
     * Consulta todos los comentarios almacenados en la base de datos.
     *
     * @return una lista de comentarios
     * @throws MongoDBException si se produce un error al consultar los comentarios
     */
    public List<Comentario> consultarComentarios() throws MongoDBException;
}
