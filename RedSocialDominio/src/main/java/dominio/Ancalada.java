/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Calendar;
import org.bson.types.ObjectId;

/**
 *
 * @author HP
 */
public class Ancalada extends Publicacion {

    private Administrador administrador;

    public Ancalada() {
    }

    public Ancalada(Administrador administrador) {
        this.administrador = administrador;
    }

    public Ancalada(Administrador administrador, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.administrador = administrador;
    }

    public Ancalada(Administrador administrador, ObjectId id, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.administrador = administrador;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

}
