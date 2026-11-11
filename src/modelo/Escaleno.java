
package modelo;

public class Escaleno extends Triangulo {

    public Escaleno(double a, double b, double c) {
        super(a, b, c);

        if (
                FabricaTriangulos.contarParesIguales(a, b, c) != 0
        ) {
            throw new IllegalArgumentException(
                    "Un escaleno requiere tres lados diferentes."
            );
        }
    }

    @Override
    public void setLados(double a, double b, double c) {
        if (
                FabricaTriangulos.contarParesIguales(a, b, c) != 0
        ) {
            throw new IllegalArgumentException(
                    "Un escaleno requiere tres lados diferentes."
            );
        }

        asignarLados(a, b, c);
    }
}
