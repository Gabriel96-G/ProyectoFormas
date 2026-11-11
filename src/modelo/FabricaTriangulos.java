
package modelo;

public class FabricaTriangulos {

    private FabricaTriangulos() { }

    public static boolean iguales(double a, double b) {
        return Double.compare(a, b) == 0;
    }

    public static int contarParesIguales(
            double a, double b, double c
    ) {
        int pares = 0;

        if (iguales(a, b)) pares++;
        if (iguales(a, c)) pares++;
        if (iguales(b, c)) pares++;

        return pares;
    }

    public static Triangulo crear(
            double a, double b, double c
    ) {
        int pares = contarParesIguales(a, b, c);

        if (pares == 3) {
            return new Equilatero(a);
        }

        if (pares == 1) {
            return new Isosceles(a, b, c);
        }

        return new Escaleno(a, b, c);
    }
}
