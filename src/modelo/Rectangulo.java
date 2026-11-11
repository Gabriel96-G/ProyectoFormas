
package modelo;

public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = validarMedida(base);
    }

    public void setAltura(double altura) {
        this.altura = validarMedida(altura);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double[] getMedidas() {
        return new double[]{base, altura};
    }
}
