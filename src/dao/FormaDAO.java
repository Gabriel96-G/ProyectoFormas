
package dao;

import modelo.Forma;
import modelo.Figura;
import modelo.Cuerpo;
import java.sql.SQLException;
import java.util.List;

public interface FormaDAO {
    void guardar(Forma forma) throws SQLException;

    List<Figura> listarFiguras() throws SQLException;

    List<Cuerpo> listarCuerpos() throws SQLException;
}
