/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class UsuarioValidacion {

    public UsuarioValidacion() {
    }

    //Validaciones
    public List<String> validarUsuario(Usuario usuario) {

        List<String> errores = new ArrayList<>();

        // Validar los atributos del usuario
        if (usuario.getNombres() == null || usuario.getNombres().isEmpty()) {
            errores.add("El campo Nombres es requerido");
        }

        if (usuario.getApellidoPaterno() == null || usuario.getApellidoPaterno().isEmpty()) {
            errores.add("El campo ApellidoPaterno es requerido");
        }

        if (usuario.getApellidoMaterno() == null || usuario.getApellidoMaterno().isEmpty()) {
            errores.add("El campo ApellidoMaterno es requerido");
        }

        if (usuario.getTelefono() == null || usuario.getTelefono().isEmpty()) {
            errores.add("El campo Telefono es requerido");
        }

        if (usuario.getAvatar() == null || usuario.getAvatar().isEmpty()) {
            errores.add("El campo Avatar es requerido");
        }

        if (usuario.getCiudad() == null || usuario.getCiudad().isEmpty()) {
            errores.add("El campo Ciudad es requerido");
        }

        if (usuario.getFechaNacimiento() == null) {
            errores.add("El campo FechaNacimiento es requerido");
        }

        if (usuario.getGenero() == null) {
            errores.add("El campo Genero es requerido");
        }

        if (usuario.getCredencial() == null) {
            errores.add("La credencial del usuario es inválida");
        }
        return errores;
    }

    public List<String> validarExistencia(String avatar, String correo) {
        List<String> errores = new ArrayList<>();

        if (avatar == null || avatar.isEmpty()) {
            errores.add("El Avatar es requerido");
        }

        if (correo == null || correo.isEmpty()) {
            errores.add("El Correo es requerido");
        }

        return errores;
    }
}
