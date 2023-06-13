/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.Usuario;
import java.util.List;

/**
 * Clase que representa a un usuario normal.
 */
public class Normal extends Usuario {

    private List<Comentario> comenatarios;

    /**
     * Constructor por defecto de la clase Normal.
     */
    public Normal() {
    }

    /**
     * Obtiene la lista de comentarios del usuario normal.
     * @return La lista de comentarios del usuario normal.
     */
    public List<Comentario> getComenatarios() {
        return comenatarios;
    }

    /**
     * Establece la lista de comentarios del usuario normal.
     * @param comentarios La lista de comentarios del usuario normal.
     */
    public void setComenatarios(List<Comentario> comenatarios) {
        this.comenatarios = comenatarios;
    }

}
