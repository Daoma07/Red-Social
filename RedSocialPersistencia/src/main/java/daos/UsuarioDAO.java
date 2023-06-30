package daos;

import baseDatos.IConexionBD;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dominio.Usuario;
import excepciones.MongoDBException;
import interfaces.IUsuarioDAO;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import validaciones.UsuarioValidacion;

/**
 *
 * @author Daniel Omar Alameda, Mario Alejandro Salcedo, David Sotelo Palafox
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final IConexionBD CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Usuario> COLECCION;
    private UsuarioValidacion usuarioValidacion;

    /**
     * Constructor de la clase UsuarioDAO.
     *
     * @param CONEXION La instancia de IConexionBD utilizada para establecer la
     * conexión con la base de datos.
     */
    public UsuarioDAO(IConexionBD CONEXION) {
        this.CONEXION = CONEXION;
        this.BASE_DATOS = CONEXION.getBaseDatos();
        this.COLECCION = BASE_DATOS.getCollection("usuarios", Usuario.class);
        this.usuarioValidacion = new UsuarioValidacion();
    }

    /**
     * Registra un usuario en la base de datos.
     *
     * @param usuario El usuario a registrar.
     * @return El usuario registrado, o null si ocurrió un error o el avatar o
     * correo electrónico ya están en uso.
     */
    @Override
    public Usuario registrarUsuario(Usuario usuario) throws MongoDBException {
        try {
            List<String> errores = usuarioValidacion.validarUsuario(usuario);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("La Usuario no es válido: " + mensajeError);
            }
            if (!existeUsuario(usuario.getAvatar(), usuario.getCredencial().getCorreo())) {
                COLECCION.insertOne(usuario);
                System.out.println("Usuario registrado exitosamente");
                return usuario;
            } else {
                System.out.println("El avatar o correo electrónico ya están en uso");
                throw new MongoDBException("El avatar o correo electrónico ya están en uso");
            }
        } catch (MongoDBException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return null;
        }
    }

    /**
     * Verifica si existe un usuario con el avatar o correo electrónico dado en
     * la base de datos.
     *
     * @param correo El corre del usuario a verificar.
     * @param contrasenia La contrasenia del usuario a verificar.
     * @return true si existe un usuario con el avatar o correo electrónico
     * dado, false de lo contrario.
     */
    @Override
    public boolean existeUsuario(String correo, String contrasenia) throws MongoDBException {
        try {
            List<String> errores = usuarioValidacion.validarExistencia(correo, contrasenia);
            if (!errores.isEmpty()) {
                String mensajeError = String.join(", ", errores);
                throw new MongoDBException("Los Datos no son válidos: " + mensajeError);
            }

            Bson filtro = Filters.or(
                    Filters.eq("credencial.correo", correo),
                    Filters.eq("credencial.contrasenia", contrasenia)
            );

            long count = COLECCION.countDocuments(filtro);
            return count > 0;
        } catch (MongoDBException e) {
            System.out.println("Error al verificar la existencia del usuario: " + e.getMessage());
            return false;
        }
    }

    /**
     * Busca un usuario por su correo y contraseña.
     *
     * @param correo El correo del usuario a buscar.
     * @param contrasenia La contraseña del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra ningún usuario
     * con las credenciales proporcionadas.
     */
    @Override
    public Usuario buscarUsuarioPorCredenciales(String correo, String contrasenia) {
        try {
            // Crea un filtro para la consulta utilizando el correo y la contraseña
            Bson filtro = Filters.and(Filters.eq("credencial.correo", correo), Filters.eq("credencial.contrasenia", contrasenia));

            // Realiza la consulta en la colección de usuarios
            Usuario usuarioEncontrado = COLECCION.find(filtro).first();

            return usuarioEncontrado;
        } catch (MongoDBException e) {
            System.out.println("Error al verificar la existencia del usuario: " + e.getMessage());
            return null;
        }

    }

}
