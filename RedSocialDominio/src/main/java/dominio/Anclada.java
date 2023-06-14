/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase que representa una publicación anclada en el sistema. Hereda de la
 * clase Publicacion.
 */
public class Anclada extends Publicacion {

    private Administrador admin;

    /**
     * Constructor por defecto de la clase Anclada.
     */
    public Anclada() {
    }

    public Anclada(Administrador admin, Date fechaHoraCreacion, String titulo, String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
        this.admin = admin;
    }

    /**
     * Constructor que recibe un administrador para la publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     */
    public Anclada(Administrador admin) {
        this.admin = admin;
    }

    /**
     * Constructor que recibe un administrador, la fecha y hora de creación, el
     * título, el contenido y la fecha y hora de edición de la publicación
     * anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * anclada.
     * @param titulo El título de la publicación anclada.
     * @param contenido El contenido de la publicación anclada.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * anclada.
     */
    public Anclada(Administrador admin, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.admin = admin;
    }

    /**
     * Constructor que recibe un administrador, el ID, la fecha y hora de
     * creación, el título, el contenido y la fecha y hora de edición de la
     * publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     * @param id El ID de la publicación anclada.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * anclada.
     * @param titulo El título de la publicación anclada.
     * @param contenido El contenido de la publicación anclada.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * anclada.
     */
    public Anclada(Administrador administrador, ObjectId id, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.admin = administrador;
    }

    /**
     * Obtiene el administrador asociado a la publicación anclada.
     *
     * @return El administrador asociado a la publicación anclada.
     */
    public Administrador getAdmin() {
        return admin;
    }

    /**
     * Establece el administrador asociado a la publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     */
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

}
