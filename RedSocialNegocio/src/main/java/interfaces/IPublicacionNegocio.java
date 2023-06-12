/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Ancalada;
import dominio.Comun;
import dominio.Publicacion;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IPublicacionNegocio {

    public Comun registrarPublicacionComun(Comun publicacionComun);

    public Ancalada registrarPublicacionAnclada(Ancalada anclada);

    public Comun editarPublicacionComun(Comun publicacionComun);

    public List<Publicacion> consultarPublicaciones();

    public boolean eliminarPublicacion(Publicacion publicacion);

    public boolean existePublicacion(Publicacion publicacion);
}
