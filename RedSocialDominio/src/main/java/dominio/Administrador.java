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
 * //
 */
public class Administrador extends Usuario {

    private List<Anclada> publicacionesAncladas;

    public Administrador() {
    }

    public List<Anclada> getPublicacionesAncladas() {
        return publicacionesAncladas;
    }

    public void setPublicacionesAncladas(List<Anclada> publicacionesAncladas) {
        this.publicacionesAncladas = publicacionesAncladas;
    }

}
