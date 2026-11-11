
package modelo;

public class Isosceles extends Triangulo {

    public Isosceles(double a, double b, double c) {
        super(a, b, c);

        if (
                FabricaTriangulos.contarParesIguales(a, b, c) != 1
        ) {
            throw new IllegalArgumentException(
                    "Un isósceles requiere exactamente dos lados iguales."
            );
        }
    }

    @Override
    public void setLados(double a, double b, double c) {
        if (
                FabricaTriangulos.contarParesIguales(a, b, c) != 1
        ) {
            throw new IllegalArgumentException(
                    "Un isósceles requiere exactamente dos lados iguales."
            );
        }

        asignarLados(a, b, c);
    }
}
