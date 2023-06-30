/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redsocialweb.Exception;

/**
 *
 * @author HP
 */
public class NegocioException extends Exception {

    public NegocioException() {
    }

    public NegocioException(String string) {
        super(string);
    }

    public NegocioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public NegocioException(Throwable thrwbl) {
        super(thrwbl);
    }

    public NegocioException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
