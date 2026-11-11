
import controlador.ControladorFormas;
import dao.FormaDAOMySQL;
import vista.Menu;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            ControladorFormas controlador =
                    new ControladorFormas(
                            new FormaDAOMySQL()
                    );

            new Menu(controlador).ejecutar();

        } catch (SQLException error) {
            System.out.println(
                    "Error al conectar con MySQL: "
                            + error.getMessage()
            );

            System.out.println(
                    "Verifique que creó la base "
                            + "y configuró las variables PF_DB_* "
                            + "en IntelliJ."
            );
        }
    }
}
