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
public class Anclada extends Publicacion {

    private Administrador admin;

    public Anclada() {
    }

    public Anclada(Administrador admin) {
        this.admin = admin;
    }

    public Anclada(Administrador admin, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.admin = admin;
    }

    public Anclada(Administrador administrador, ObjectId id, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.admin = administrador;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

}
