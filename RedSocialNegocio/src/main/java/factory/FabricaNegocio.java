/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import fachada.FachadaPersistencia;
import fachada.IFachadaPersistencia;
import negocio.ComentarioNegocio;
import negocio.PublicacionNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author HP
 */
public class FabricaNegocio implements IFabricaNegocio {

    private IFachadaPersistencia fachadaPersistencia;

    public FabricaNegocio() {
        this.fachadaPersistencia = new FachadaPersistencia();
    }

    @Override
    public ComentarioNegocio crearComentarioNegocio() {
        return new ComentarioNegocio(fachadaPersistencia);
    }

    @Override
    public PublicacionNegocio crearPublicacionNegocio() {
        return new PublicacionNegocio(fachadaPersistencia);
    }

    @Override
    public UsuarioNegocio crearUsuarioNegocio() {
        return new UsuarioNegocio(fachadaPersistencia);
    }

}
