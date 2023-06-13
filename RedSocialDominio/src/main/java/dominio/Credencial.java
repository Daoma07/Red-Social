/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 * Clase que representa las credenciales de un usuario en el sistema.
 */
public class Credencial {

    private String correo;
    private String contrasenia;

    /**
     * Constructor por defecto de la clase Credencial.
     */
    public Credencial() {
    }

    /**
     * Constructor que recibe el correo y la contraseña de las credenciales.
     * @param correo El correo de las credenciales.
     * @param contrasenia La contraseña de las credenciales.
     */
    public Credencial(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el correo de las credenciales.
     * @return El correo de las credenciales.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo de las credenciales.
     * @param correo El correo de las credenciales.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña de las credenciales.
     * @return La contraseña de las credenciales.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña de las credenciales.
     * @param contrasenia La contraseña de las credenciales.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
