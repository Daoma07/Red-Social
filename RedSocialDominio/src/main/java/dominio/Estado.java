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
 * Clase que representa un estado en un país.
 */
public class Estado {

    private ObjectId id;
    private String nombre;
    private List<Municipio> municipos;

    /**
     * Constructor por defecto de la clase Estado.
     */
    public Estado() {
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que recibe el nombre y la lista de municipios del estado.
     *
     * @param nombre El nombre del estado.
     * @param municipos La lista de municipios del estado.
     */
    public Estado(String nombre, List<Municipio> municipos) {
        this.nombre = nombre;
        this.municipos = municipos;
    }

    /**
     * Constructor que recibe el ID, el nombre y la lista de municipios del
     * estado.
     *
     * @param id El ID del estado.
     * @param nombre El nombre del estado.
     * @param municipos La lista de municipios del estado.
     */
    public Estado(ObjectId id, String nombre, List<Municipio> municipos) {
        this.id = id;
        this.nombre = nombre;
        this.municipos = municipos;
    }

    /**
     * Obtiene el ID del estado.
     *
     * @return El ID del estado.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del estado.
     *
     * @param id El ID del estado.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estado.
     *
     * @return El nombre del estado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado.
     *
     * @param nombre El nombre del estado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de municipios del estado.
     *
     * @return La lista de municipios del estado.
     */
    public List<Municipio> getMunicipos() {
        return municipos;
    }

    /**
     * Establece la lista de municipios del estado.
     *
     * @param municipos La lista de municipios del estado.
     */
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
