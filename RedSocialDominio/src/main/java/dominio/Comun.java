/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa una publicación común en el sistema.
 */
public class Comun extends Publicacion {

    private Usuario usuario;
    private List<Comentario> comentarios;

    /**
     * Constructor por defecto de la clase Comun.
     */
    public Comun() {
    }

    /**
     * Constructor que recibe el usuario asociado a la publicación común.
     *
     * @param usuario El usuario asociado a la publicación común.
     */
    public Comun(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comun(Usuario usuario, Date fechaHoraCreacion, String titulo, String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
        this.usuario = usuario;
    }

    /**
     * Constructor que recibe el usuario asociado, la fecha y hora de creación,
     * el título, el contenido y la fecha y hora de edición de la publicación
     * común.
     *
     * @param usuario El usuario asociado a la publicación común.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * común.
     * @param titulo El título de la publicación común.
     * @param contenido El contenido de la publicación común.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * común.
     */
    public Comun(Usuario usuario, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    /**
     * Constructor que recibe el usuario asociado, el ID, la fecha y hora de
     * creación, el título, el contenido y la fecha y hora de edición de la
     * publicación común.
     *
     * @param usuario El usuario asociado a la publicación común.
     * @param id El ID de la publicación común.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * común.
     * @param titulo El título de la publicación común.
     * @param contenido El contenido de la publicación común.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * común.
     */
    public Comun(Usuario usuario, ObjectId id, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    /**
     * Obtiene el usuario asociado a la publicación común.
     *
     * @return El usuario asociado a la publicación común.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a la publicación común.
     *
     * @param usuario El usuario asociado a la publicación común.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de comentarios asociados a la publicación común.
     *
     * @return La lista de comentarios asociados a la publicación común.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de comentarios asociados a la publicación común.
     *
     * @param comentarios La lista de comentarios asociados a la publicación
     * común.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Comun{" + "usuario=" + usuario + ", comentarios=" + comentarios + '}';
    }

}
