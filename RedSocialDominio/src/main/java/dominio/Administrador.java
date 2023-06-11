/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;

/**
 *
 * @author HP
 */
public class Administrador extends Usuario {

    private List<Ancalada> publicacionesAncladas;

    public Administrador() {
    }

    public List<Ancalada> getPublicacionesAncladas() {
        return publicacionesAncladas;
    }

    public void setPublicacionesAncladas(List<Ancalada> publicacionesAncladas) {
        this.publicacionesAncladas = publicacionesAncladas;
    }

}
