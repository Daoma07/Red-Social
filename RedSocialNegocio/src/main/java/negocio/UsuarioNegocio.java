/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Usuario;
import fachada.IFachadaPersistencia;

/**
 *
 * @author HP
 */
public class UsuarioNegocio {

    private final IFachadaPersistencia fachadaPersistencia;

    public UsuarioNegocio(IFachadaPersistencia fachadaPersistencia) {
        this.fachadaPersistencia = fachadaPersistencia;
    }

    public Usuario registrarUsuario(Usuario usuario) {

        if (usuario.getNombres() == null || usuario.getNombres().isEmpty()) {
            throw new IllegalArgumentException("El campo 'nombres' es obligatorio.");
        }

        if (usuario.getApellidoPaterno() == null || usuario.getApellidoPaterno().isEmpty()) {
            throw new IllegalArgumentException("El campo 'apellido paterno' es obligatorio.");
        }

        if (usuario.getTelefono() == null || usuario.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("El campo 'teléfono' es obligatorio.");
        }

        if (usuario.getAvatar() == null || usuario.getAvatar().isEmpty()) {
            throw new IllegalArgumentException("El campo 'avatar' es obligatorio.");
        }

        if (usuario.getCiudad() == null || usuario.getCiudad().isEmpty()) {
            throw new IllegalArgumentException("El campo 'ciudad' es obligatorio.");
        }

        if (usuario.getFechaNacimiento() == null) {
            throw new IllegalArgumentException("El campo 'fecha de nacimiento' es obligatorio.");
        }

        if (usuario.getGenero() == null) {
            throw new IllegalArgumentException("El campo 'género' es obligatorio.");
        }

        if (usuario.getCredencial() == null) {
            throw new IllegalArgumentException("El campo 'credencial' es obligatorio.");
        }

        if (usuario.getMunicipio() == null) {
            throw new IllegalArgumentException("El campo 'municipio' es obligatorio.");
        }
        return fachadaPersistencia.registrarUsuario(usuario);
    }

}
