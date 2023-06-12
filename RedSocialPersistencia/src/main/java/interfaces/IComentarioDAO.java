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
 *
 * @author HP
 */
public interface IComentarioDAO {

    public Comentario registrarComentario(Comentario comentario) throws MongoDBException;

    public boolean eliminarComentario(Comentario comentario) throws MongoDBException;

    public List<Comentario> consultarComentarios() throws MongoDBException;
}
