/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.Usuario;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa a un usuario normal.
 */
public class Normal extends Usuario {

    private List<Comentario> comenatarios;

    public Normal() {
    }

    public Normal(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String avatar, String ciudad, Date fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, telefono, avatar, ciudad, fechaNacimiento, genero, credencial, municipio);
    }

    public Normal(ObjectId id, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String avatar, String ciudad, Date fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, telefono, avatar, ciudad, fechaNacimiento, genero, credencial, municipio);
    }

    /**
     * Obtiene la lista de comentarios del usuario normal.
     *
     * @return La lista de comentarios del usuario normal.
     */
    public List<Comentario> getComenatarios() {
        return comenatarios;
    }

    /**
     * Establece la lista de comentarios del usuario normal.
     *
     * @param comentarios La lista de comentarios del usuario normal.
     */
    public void setComenatarios(List<Comentario> comenatarios) {
        this.comenatarios = comenatarios;
    }

}
