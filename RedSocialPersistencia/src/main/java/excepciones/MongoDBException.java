/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import com.mongodb.MongoException;

/**
 *
 * @author HP
 */
public class MongoDBException extends MongoException {

    public MongoDBException(String msg) {
        super(msg);
    }

    public MongoDBException(int code, String msg) {
        super(code, msg);
    }

    public MongoDBException(String msg, Throwable t) {
        super(msg, t);
    }

    public MongoDBException(int code, String msg, Throwable t) {
        super(code, msg, t);
    }

}
