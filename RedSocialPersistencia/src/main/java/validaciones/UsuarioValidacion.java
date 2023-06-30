package validaciones;

import dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Omar Alameda, Mario Alejandro Salcedo, David Sotelo Palafox
 */
public class UsuarioValidacion {

    /**
     * Constructor por defecto
     */
    public UsuarioValidacion() {
    }

    /**
     * Método List validarUsuario que recibe como parámetro un usuario
     *
     * @param usuario
     * @return Lista Caracteres errores
     */
    public List<String> validarUsuario(Usuario usuario) {

        List<String> errores = new ArrayList<>();

        //Condición if Nombre de Usuario igual a nulo o vacío return String
        if (usuario.getNombres() == null || usuario.getNombres().isEmpty()) {
            errores.add("El campo Nombres es requerido");
        }
        //Condición if Apellido Paterno de Usuario igual a nulo o vacío return String
        if (usuario.getApellidoPaterno() == null || usuario.getApellidoPaterno().isEmpty()) {
            errores.add("El campo ApellidoPaterno es requerido");
        }
        //Condición if Apellido Materno de Usuario igual a nulo o vacío return String
        if (usuario.getApellidoMaterno() == null || usuario.getApellidoMaterno().isEmpty()) {
            errores.add("El campo ApellidoMaterno es requerido");
        }
        //Condición if teléfono de Usuario igual a nulo o vacío return String
        if (usuario.getTelefono() == null || usuario.getTelefono().isEmpty()) {
            errores.add("El campo Telefono es requerido");
        }
        //Condición if avatar de Usuario igual a nulo o vacío return String
        if (usuario.getAvatar() == null || usuario.getAvatar().isEmpty()) {
            errores.add("El campo Avatar es requerido");
        }
        //Condición if ciudad de Usuario igual a nulo o vacío return String
        if (usuario.getCiudad() == null || usuario.getCiudad().isEmpty()) {
            errores.add("El campo Ciudad es requerido");
        }
        //Condición if fecha nacimiento de Usuario igual a nulo return String
        if (usuario.getFechaNacimiento() == null) {
            errores.add("El campo FechaNacimiento es requerido");
        }
        //Condición if Género de Usuario igual a  return String
        if (usuario.getGenero() == null) {
            errores.add("El campo Genero es requerido");
        }
        //Condición if Credencial de Usuario igual a nulo return String
        if (usuario.getCredencial() == null) {
            errores.add("La credencial del usuario es inválida");
        }
        return errores;
    }

    /**
     * Método List validarExistencia que recibe como parámetro un avatar y
     * correo encargado de validar la existencia del avatar y correo
     *
     * @param contrasenia
     * @param correo
     * @return Lista Caracteres errores
     */
    public List<String> validarExistencia(String correo, String contrasenia) {
        List<String> errores = new ArrayList<>();
        //Condición if correo a vacío o nulo return String
        if (contrasenia == null || contrasenia.isEmpty()) {
            errores.add("La contraseña es requerido");
        }
        //Condición if Correo igual a vacío o nulo return String
        if (correo == null || correo.isEmpty()) {
            errores.add("El Correo es requerido");
        }

        return errores;
    }
}
