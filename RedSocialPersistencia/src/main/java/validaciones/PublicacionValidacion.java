/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import dominio.Anclada;
import dominio.Comun;
import dominio.Publicacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PublicacionValidacion {

    public PublicacionValidacion() {
    }

    //Validaciones 
    public List<String> validarPublicacion(Publicacion publicacion) {
        List<String> errores = new ArrayList<>();

        // Validar los atributos de la publicación común
        if (publicacion.getFechaHoraCreacion() == null) {
            errores.add("El campo FechaHoraCreacion es requerido");
        }

        if (publicacion.getTitulo() == null || publicacion.getTitulo().isEmpty()) {
            errores.add("El campo Titulo es requerido");
        }

        if (publicacion.getContenido() == null || publicacion.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }

        return errores;
    }

    public List<String> validarPublicacionComun(Comun publicacionComun) {
        List<String> errores = new ArrayList<>();

        // Validar los atributos de la publicación común
        if (publicacionComun.getFechaHoraCreacion() == null) {
            errores.add("El campo FechaHoraCreacion es requerido");
        }

        if (publicacionComun.getTitulo() == null || publicacionComun.getTitulo().isEmpty()) {
            errores.add("El campo Titulo es requerido");
        }

        if (publicacionComun.getContenido() == null || publicacionComun.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }

        // Validar atributos específicos de la clase Comun
        if (publicacionComun.getUsuario() == null) {
            errores.add("El campo Usuario es requerido");
        }

        return errores;
    }

    public List<String> validarPublicacionAnclada(Anclada anclada) {
        List<String> errores = new ArrayList<>();

        // Validar los atributos de la publicación anclada
        if (anclada.getFechaHoraCreacion() == null) {
            errores.add("El campo FechaHoraCreacion es requerido");
        }

        if (anclada.getTitulo() == null || anclada.getTitulo().isEmpty()) {
            errores.add("El campo Titulo es requerido");
        }

        if (anclada.getContenido() == null || anclada.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }

        // Validar atributos específicos de la clase Anclada
        if (anclada.getAdmin() == null) {
            errores.add("El campo Admin es requerido");
        }

        return errores;
    }

}