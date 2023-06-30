package factory;

import baseDatos.ConexionMongoDB;
import baseDatos.IConexionBD;
import interfaces.IComentarioDAO;
import interfaces.IPublicacionDAO;
import interfaces.IUsuarioDAO;
import daos.ComentarioDAO;
import daos.PublicacionDAO;
import daos.UsuarioDAO;
import dominio.Usuario;

/**
 * @author Daniel Omar Alameda, Mario Alejandro Salcedo, David Sotelo Palafox
 * Esta clase actúa como una fábrica para crear instancias de los DAO
 * correspondientes.
 */
public class FabricaDAO implements IFabricaDAO {

    private IConexionBD conexion;

    /**
     * Constructor de la clase FabricaDAO. Crea una instancia de la clase
     * ConexionMongoDB para establecer la conexión con la base de datos.
     */
    public FabricaDAO() {
        this.conexion = new ConexionMongoDB();
    }

    /**
     * Crea y devuelve una instancia de ComentarioDAO.
     *
     * @return una instancia de ComentarioDAO
     */
    @Override
    public IComentarioDAO crearComentarioDAO() {
        return new ComentarioDAO(conexion);
    }

    /**
     * Crea y devuelve una instancia de PublicacionDAO.
     *
     * @return una instancia de PublicacionDAO
     */
    @Override
    public IPublicacionDAO crearPublicacionDAO() {
        return new PublicacionDAO(conexion);
    }

    /**
     * Crea y devuelve una instancia de UsuarioDAO.
     *
     * @return una instancia de UsuarioDAO
     */
    @Override
    public IUsuarioDAO crearUsuarioDAO() {
        return new UsuarioDAO(conexion);
    }

}
