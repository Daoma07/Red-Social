/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;

/**
 * Clase que representa un administrador en el sistema.
 * Hereda de la clase Usuario.
 */
public class Administrador extends Usuario {

    
    private List<Anclada> publicacionesAncladas;

    /**
     * Constructor por defecto de la clase Administrador.
     */
    public Administrador() {
    }

    /**
     * Obtiene la lista de publicaciones ancladas asociadas al administrador.
     * @return La lista de publicaciones ancladas.
     */
    public List<Anclada> getPublicacionesAncladas() {
        return publicacionesAncladas;
    }

    /**
     * Establece la lista de publicaciones ancladas asociadas al administrador.
     * @param publicacionesAncladas La lista de publicaciones ancladas.
     */
    public void setPublicacionesAncladas(List<Anclada> publicacionesAncladas) {
        this.publicacionesAncladas = publicacionesAncladas;
    }

}
