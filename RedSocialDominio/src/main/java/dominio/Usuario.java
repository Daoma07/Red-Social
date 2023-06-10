/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Calendar;
import org.bson.types.ObjectId;

/**
 *
 * @author HP
 */
public class Usuario {

    private ObjectId id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String avatar;
    private String ciudad;
    private Calendar fechaNacimiento;
    private Genero genero;
    private Credencial credencial;
    private Municipio municipio;

}
