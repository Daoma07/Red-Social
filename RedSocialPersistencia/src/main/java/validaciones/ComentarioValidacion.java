/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import dominio.Comentario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ComentarioValidacion {

    public ComentarioValidacion() {
    }

    public List<String> validarComentario(Comentario comentario) {
        List<String> errores = new ArrayList<>();

        if (comentario == null) {
            errores.add("El comentario esta vacio");
        }

        if (comentario.getFechaHora() == null) {
            errores.add("El campo FechaHora es requerido");
        }

        if (comentario.getContenido() == null || comentario.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }

        if (comentario.getUsuarioNormal() == null) {
            errores.add("El campo UsuarioNormal es requerido");
        }

        if (comentario.getPublicacionComun() == null) {
            errores.add("El campo PublicacionComun es requerido");
        }

        return errores;
    }

}
