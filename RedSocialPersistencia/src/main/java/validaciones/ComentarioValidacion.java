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
 * @author Daniel Omar Alameda, Mario Alejandro Salcedo, David Sotelo Palafox
 */
public class ComentarioValidacion {

    public ComentarioValidacion() {
    }
    /**
     * Método validarComentario que recibe como parámetro un comentario
     * @param comentario
     * @return validarComentario
     */
    public List<String> validarComentario(Comentario comentario) {
        List<String> errores = new ArrayList<>();
        //Condición if comentario igual a nulo return String
        if (comentario == null) {
            errores.add("El comentario esta vacio");
        }
        //Condición if fecha de comentario igual a nulo return String
        if (comentario.getFechaHora() == null) {
            errores.add("El campo FechaHora es requerido");
        }
        //Condición if contenido comentario igual a nulo o vacío return String
        if (comentario.getContenido() == null || comentario.getContenido().isEmpty()) {
            errores.add("El campo Contenido es requerido");
        }
        //Condición if comentario de usuario normal igual a nulo return String
        if (comentario.getUsuarioNormal() == null) {
            errores.add("El campo UsuarioNormal es requerido");
        }
        //Condición if comentario de publicación igual a nulo return String
        if (comentario.getPublicacionComun() == null) {
            errores.add("El campo PublicacionComun es requerido");
        }

        return errores;
    }

}
