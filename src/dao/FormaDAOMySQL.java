
package dao;

import modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FormaDAOMySQL implements FormaDAO {

    @Override
    public void guardar(Forma forma) throws SQLException {
        if (
                forma == null ||
                        !(forma instanceof Figura || forma instanceof Cuerpo)
        ) {
            throw new IllegalArgumentException(
                    "Solo pueden guardarse figuras y cuerpos."
            );
        }

        String categoria = forma instanceof Figura
                ? "FIGURA" : "CUERPO";

        String tipo = forma.getClass()
                .getSimpleName()
                .toUpperCase(Locale.ROOT);

        double[] medidas = forma instanceof Figura
                ? ((Figura) forma).getMedidas()
                : ((Cuerpo) forma).getMedidas();

        String sql =
                "INSERT INTO forma_registro "
                        + "(categoria, tipo, medida1, medida2, medida3) "
                        + "VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conexion = ConexionMySQL.conectar();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, categoria);
            sentencia.setString(2, tipo);
            sentencia.setDouble(3, medidas[0]);

            for (int i = 1; i < 3; i++) {
                if (i < medidas.length) {
                    sentencia.setDouble(i + 3, medidas[i]);
                } else {
                    sentencia.setNull(i + 3, Types.DOUBLE);
                }
            }

            sentencia.executeUpdate();
        }
    }

    @Override
    public List<Figura> listarFiguras() throws SQLException {
        List<Figura> figuras = new ArrayList<>();

        for (Forma forma : cargarTodas()) {
            if (forma instanceof Figura) {
                figuras.add((Figura) forma);
            }
        }

        return figuras;
    }

    @Override
    public List<Cuerpo> listarCuerpos() throws SQLException {
        List<Cuerpo> cuerpos = new ArrayList<>();

        for (Forma forma : cargarTodas()) {
            if (forma instanceof Cuerpo) {
                cuerpos.add((Cuerpo) forma);
            }
        }

        return cuerpos;
    }

    private List<Forma> cargarTodas() throws SQLException {
        List<Forma> formas = new ArrayList<>();

        String sql =
                "SELECT categoria, tipo, medida1, "
                        + "medida2, medida3 "
                        + "FROM forma_registro ORDER BY id";

        try (
                Connection conexion = ConexionMySQL.conectar();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {
            while (resultado.next()) {
                String categoria = resultado.getString("categoria");
                String tipo = resultado.getString("tipo");

                double a = resultado.getDouble("medida1");
                double b = resultado.getDouble("medida2");
                double c = resultado.getDouble("medida3");

                try {
                    Forma forma = reconstruir(tipo, a, b, c);

                    if (
                            categoria.equals("FIGURA")
                                    && forma instanceof Figura
                                    ||
                                    categoria.equals("CUERPO")
                                            && forma instanceof Cuerpo
                    ) {
                        formas.add(forma);
                    } else {
                        throw new SQLException(
                                "Categoría inválida para " + tipo
                        );
                    }
                } catch (IllegalArgumentException e) {
                    throw new SQLException(
                            "Registro inválido de " + tipo
                                    + ": " + e.getMessage(),
                            e
                    );
                }
            }
        }

        return formas;
    }

    private Forma reconstruir(
            String tipo, double a, double b, double c
    ) throws SQLException {
        switch (tipo) {
            case "CIRCULO":
                return new Circulo(a);

            case "RECTANGULO":
                return new Rectangulo(a, b);

            case "CUADRADO":
                return new Cuadrado(a);

            case "ROMBO":
                return new Rombo(a, b);

            case "EQUILATERO":
            case "ISOSCELES":
            case "ESCALENO":
                Triangulo triangulo =
                        FabricaTriangulos.crear(a, b, c);

                if (
                        !triangulo.getClass()
                                .getSimpleName()
                                .equalsIgnoreCase(tipo)
                ) {
                    throw new SQLException(
                            "Tipo de triángulo incoherente "
                                    + "con sus lados."
                    );
                }

                return triangulo;

            case "CUBO":
                return new Cubo(new Cuadrado(a));

            case "CILINDRO":
                return new Cilindro(new Circulo(a), b);

            case "TETRAEDRO":
                return new Tetraedro(new Equilatero(a));

            case "ESFERA":
                return new Esfera(a);

            default:
                throw new SQLException(
                        "Tipo desconocido en MySQL: " + tipo
                );
        }
    }
}
