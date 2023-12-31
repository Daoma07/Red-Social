
package dominio;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa un administrador en el sistema. Hereda de la clase
 * Usuario.
 */
public class Administrador extends Usuario {

    private List<Anclada> publicacionesAncladas;

    public Administrador() {
    }

    public Administrador(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String avatar, String ciudad, Date fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, telefono, avatar, ciudad, fechaNacimiento, genero, credencial, municipio);
    }

    public Administrador(ObjectId id, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String avatar, String ciudad, Date fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, telefono, avatar, ciudad, fechaNacimiento, genero, credencial, municipio);
    }

    /**
     * Obtiene la lista de publicaciones ancladas asociadas al administrador.
     *
     * @return La lista de publicaciones ancladas.
     */
    public List<Anclada> getPublicacionesAncladas() {
        return publicacionesAncladas;
    }

    /**
     * Establece la lista de publicaciones ancladas asociadas al administrador.
     *
     * @param publicacionesAncladas La lista de publicaciones ancladas.
     */
    public void setPublicacionesAncladas(List<Anclada> publicacionesAncladas) {
        this.publicacionesAncladas = publicacionesAncladas;
    }

}
