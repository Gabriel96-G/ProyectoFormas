
import modelo.*;

public class PruebaFormas {

    public static void main(String[] args) {
        probar(
                "Círculo área",
                new Circulo(2).calcularArea(),
                4 * Math.PI
        );

        probar(
                "Cuadrado área",
                new Cuadrado(3).calcularArea(),
                9
        );

        probar(
                "Rombo área",
                new Rombo(6, 4).calcularArea(),
                12
        );

        probar(
                "Triángulo equilátero",
                FabricaTriangulos.crear(3, 3, 3)
                        instanceof Equilatero
        );

        probar(
                "Triángulo isósceles",
                FabricaTriangulos.crear(5, 5, 6)
                        instanceof Isosceles
        );

        probar(
                "Triángulo escaleno",
                FabricaTriangulos.crear(3, 4, 5)
                        instanceof Escaleno
        );

        probar(
                "Cubo volumen",
                new Cubo(new Cuadrado(2))
                        .calcularVolumen(),
                8
        );

        probar(
                "Cilindro volumen",
                new Cilindro(new Circulo(2), 3)
                        .calcularVolumen(),
                12 * Math.PI
        );

        probar(
                "Tetraedro volumen",
                new Tetraedro(new Equilatero(2))
                        .calcularVolumen(),
                2 * Math.sqrt(2) / 3
        );

        probar(
                "Esfera volumen",
                new Esfera(3).calcularVolumen(),
                36 * Math.PI
        );

        Coleccion c = new Coleccion();

        c.agregarFigura(new Cuadrado(2));

        c.agregarCuerpo(
                new Cubo(new Cuadrado(2))
        );

        probar(
                "Colección área",
                c.calcularAreaTotal(),
                28
        );

        probar(
                "Colección perímetro",
                c.calcularPerimetroTotal(),
                32
        );

        probar(
                "Colección volumen",
                c.calcularVolumenTotal(),
                8
        );

        System.out.println(
                "Pruebas geométricas finalizadas."
        );
    }

    private static void probar(
            String nombre,
            double actual,
            double esperado
    ) {
        if (Math.abs(actual - esperado) > 1e-7) {
            throw new AssertionError(
                    nombre + ": " + actual
                            + " != " + esperado
            );
        }

        System.out.println("OK: " + nombre);
    }

    private static void probar(
            String nombre,
            boolean correcto
    ) {
        if (!correcto) {
            throw new AssertionError(nombre);
        }

        System.out.println("OK: " + nombre);
    }
}
