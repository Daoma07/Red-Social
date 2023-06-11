/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author HP
 */
public class Comentario {

    private ObjectId id;
    private Calendar fechaHora;
    private String contenido;
    private Normal usuarioNormal;
    private Comun publicacionComun;
    private List<Comentario> comentarios;

    public Comentario() {
    }

    public Comentario(Calendar fechaHora, String contenido, Normal usuarioNormal, Comun publicacionComun) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.publicacionComun = publicacionComun;
    }

    public Comentario(ObjectId id, Calendar fechaHora, String contenido, Normal usuarioNormal, Comun publicacionComun, List<Comentario> comentarios) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.publicacionComun = publicacionComun;
        this.comentarios = comentarios;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Normal getUsuarioNormal() {
        return usuarioNormal;
    }

    public void setUsuarioNormal(Normal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    public Comun getPublicacionComun() {
        return publicacionComun;
    }

    public void setPublicacionComun(Comun publicacionComun) {
        this.publicacionComun = publicacionComun;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", usuarioNormal=" + usuarioNormal + ", publicacionComun=" + publicacionComun + ", comentarios=" + comentarios + '}';
    }

}
