/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author HP
 */
public class Estado {

    private ObjectId id;
    private String nombre;
    private List<Municipio> municipos;

    public Estado() {
    }

    public Estado(String nombre, List<Municipio> municipos) {
        this.nombre = nombre;
        this.municipos = municipos;
    }

    public Estado(ObjectId id, String nombre, List<Municipio> municipos) {
        this.id = id;
        this.nombre = nombre;
        this.municipos = municipos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Municipio> getMunicipos() {
        return municipos;
    }

    public void setMunicipos(List<Municipio> municipos) {
        this.municipos = municipos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nombre=" + nombre + ", municipos=" + municipos + '}';
    }

}
