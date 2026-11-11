
package modelo;

public class Cubo extends Cuerpo {
    private Cuadrado cara;

    public Cubo(Cuadrado cara) {
        setCara(cara);
    }

    public Cuadrado getCara() {
        return new Cuadrado(cara.getLado());
    }

    public void setCara(Cuadrado cara) {
        if (cara == null) {
            throw new IllegalArgumentException(
                    "Se requiere una cara cuadrada."
            );
        }

        this.cara = new Cuadrado(cara.getLado());
    }

    public double getArista() {
        return cara.getLado();
    }

    @Override
    public double calcularPerimetro() {
        return 12 * getArista();
    }

    @Override
    public double calcularArea() {
        return 6 * cara.calcularArea();
    }

    @Override
    public double calcularVolumen() {
        return Math.pow(getArista(), 3);
    }

    @Override
    public double[] getMedidas() {
        return new double[]{getArista()};
    }
}
