/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import com.mongodb.MongoException;

/**
 * Excepción personalizada para manejar errores relacionados con MongoDB.
 */

public class MongoDBException extends MongoException {

    /**
     * Crea una nueva instancia de MongoDBException con un mensaje de error.
     *
     * @param msg El mensaje de error.
     */
    public MongoDBException(String msg) {
        super(msg);
    }

    /**
     * Crea una nueva instancia de MongoDBException con un código de error y un mensaje.
     *
     * @param code El código de error.
     * @param msg  El mensaje de error.
     */
    public MongoDBException(int code, String msg) {
        super(code, msg);
    }

    /**
     * Crea una nueva instancia de MongoDBException con un mensaje de error y una causa subyacente.
     *
     * @param msg El mensaje de error.
     * @param t   La causa subyacente.
     */
    public MongoDBException(String msg, Throwable t) {
        super(msg, t);
    }

    /**
     * Crea una nueva instancia de MongoDBException con un código de error, un mensaje y una causa subyacente.
     *
     * @param code El código de error.
     * @param msg  El mensaje de error.
     * @param t    La causa subyacente.
     */
    
    public MongoDBException(int code, String msg, Throwable t) {
        super(code, msg, t);
    }

}

