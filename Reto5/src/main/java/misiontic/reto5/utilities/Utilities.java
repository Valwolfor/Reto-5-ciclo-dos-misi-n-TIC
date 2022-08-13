
package misiontic.reto5.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Utilities {
    // Atributos de clase para gestión de conexión con la base de datos
    private static final String UBICACION_BD = "ProyectosConstruccion.db";
    //JDBC método para poder instanciar y conectar la base de datos cuando se necesite. 
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
       
    return DriverManager.getConnection(url);
            
 }
}
