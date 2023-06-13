/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author HP
 */
public class ConexionMongoDB implements IConexionBD {

    public final static String NOMBRE_BASE_DATOS = "red_social";
    private MongoDatabase baseDatos;

    /**
    * Devuelve la instancia de la base de datos MongoDB.
    *
    * @return La instancia de la base de datos MongoDB.
    */
    @Override
    public MongoDatabase getBaseDatos() {
        if (baseDatos == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            MongoClient conexion = MongoClients.create(settings);
            baseDatos = conexion.getDatabase(NOMBRE_BASE_DATOS);
        }
        return baseDatos;
    }

}
