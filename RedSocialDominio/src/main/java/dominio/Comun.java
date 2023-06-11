/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Calendar;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author HP
 */
public class Comun extends Publicacion {

    private Usuario usuario;
    private List<Comentario> comentarios;

    public Comun() {
    }

    public Comun(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comun(Usuario usuario, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    public Comun(Usuario usuario, ObjectId id, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Comun{" + "usuario=" + usuario + ", comentarios=" + comentarios + '}';
    }

}
