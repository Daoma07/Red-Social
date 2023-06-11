/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.Usuario;
import java.util.List;

/**
 *
 * @author HP
 */
public class Normal extends Usuario {

    private List<Comentario> comenatarios;

    public Normal() {
    }

    public List<Comentario> getComenatarios() {
        return comenatarios;
    }

    public void setComenatarios(List<Comentario> comenatarios) {
        this.comenatarios = comenatarios;
    }

}
