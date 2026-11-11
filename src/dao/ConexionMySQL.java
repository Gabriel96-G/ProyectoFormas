
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    private ConexionMySQL() { }

    public static Connection conectar() throws SQLException {
        String url = System.getenv("PF_DB_URL");
        String usuario = System.getenv("PF_DB_USER");
        String clave = System.getenv("PF_DB_PASSWORD");

        if (url == null || usuario == null || clave == null) {
            throw new SQLException(
                    "Configure PF_DB_URL, PF_DB_USER "
                            + "y PF_DB_PASSWORD en IntelliJ."
            );
        }

        return DriverManager.getConnection(
                url, usuario, clave
        );
    }
}
