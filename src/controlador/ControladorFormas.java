
package controlador;

import dao.FormaDAO;
import modelo.Coleccion;
import modelo.Cuerpo;
import modelo.Figura;

import java.sql.SQLException;
import java.util.List;

public class ControladorFormas {
    private final Coleccion coleccion;
    private final FormaDAO dao;

    public ControladorFormas(FormaDAO dao)
            throws SQLException {

        if (dao == null) {
            throw new IllegalArgumentException(
                    "Se requiere el DAO."
            );
        }

        this.dao = dao;
        this.coleccion = new Coleccion();

        coleccion.setFiguras(dao.listarFiguras());
        coleccion.setCuerpos(dao.listarCuerpos());
    }

    public void agregarFigura(Figura figura)
            throws SQLException {

        dao.guardar(figura);
        coleccion.agregarFigura(figura);
    }

    public void agregarCuerpo(Cuerpo cuerpo)
            throws SQLException {

        dao.guardar(cuerpo);
        coleccion.agregarCuerpo(cuerpo);
    }

    public List<Figura> getFiguras() {
        return coleccion.getFiguras();
    }

    public List<Cuerpo> getCuerpos() {
        return coleccion.getCuerpos();
    }

    public double calcularAreaTotal() {
        return coleccion.calcularAreaTotal();
    }

    public double calcularPerimetroTotal() {
        return coleccion.calcularPerimetroTotal();
    }

    public double calcularVolumenTotal() {
        return coleccion.calcularVolumenTotal();
    }
}
