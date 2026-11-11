
package modelo;

public abstract class Triangulo extends Figura {
    private double lado1;
    private double lado2;
    private double lado3;

    protected Triangulo(double lado1, double lado2, double lado3) {
        asignarLados(lado1, lado2, lado3);
    }

    protected final void asignarLados(
            double a, double b, double c
    ) {
        validarMedida(a);
        validarMedida(b);
        validarMedida(c);

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException(
                    "Los lados no forman un triángulo válido."
            );
        }

        lado1 = a;
        lado2 = b;
        lado3 = c;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public abstract void setLados(
            double a, double b, double c
    );

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public double calcularArea() {
        double s = calcularPerimetro() / 2;

        return Math.sqrt(
                s * (s - lado1)
                        * (s - lado2)
                        * (s - lado3)
        );
    }

    @Override
    public double[] getMedidas() {
        return new double[]{
                lado1, lado2, lado3
        };
    }
}
