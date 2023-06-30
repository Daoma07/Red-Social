package interfaces;

import dominio.Usuario;
import excepciones.MongoDBException;

/**
 * Esta interfaz define los métodos para realizar operaciones relacionadas con
 * los usuarios en la base de datos.
 */
public interface IUsuarioDAO {

    /**
     * Registra un usuario en la base de datos.
     *
     * @param usuario el usuario a registrar
     * @return el usuario registrado
     * @throws MongoDBException si se produce un error al registrar el usuario
     */
    public Usuario registrarUsuario(Usuario usuario) throws MongoDBException;

    /**
     * Verifica la existencia de un usuario en la base de datos.
     *
     * @param correo el correo electrónico del usuario
     * @param contrasenia la contrasenia del usuario
     * @return true si el usuario existe, false si no existe
     * @throws MongoDBException si se produce un error al verificar la
     * existencia del usuario
     */
    public boolean existeUsuario(String correo, String contrasenia) throws MongoDBException;

    /**
     * Busca un usuario por su correo y contraseña.
     *
     * @param correo El correo del usuario a buscar.
     * @param contrasenia La contraseña del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra ningún usuario
     * con las credenciales proporcionadas.
     */
    public Usuario buscarUsuarioPorCredenciales(String correo, String contrasenia);

}
