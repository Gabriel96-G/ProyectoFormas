
package modelo;

public class Equilatero extends Triangulo {

    public Equilatero(double lado) {
        super(lado, lado, lado);
    }

    public double getLado() {
        return getLado1();
    }

    public void setLado(double lado) {
        asignarLados(lado, lado, lado);
    }

    @Override
    public void setLados(double a, double b, double c) {
        if (
                FabricaTriangulos.contarParesIguales(a, b, c) != 3
        ) {
            throw new IllegalArgumentException(
                    "Un equilátero requiere tres lados iguales."
            );
        }

        asignarLados(a, b, c);
    }
}
