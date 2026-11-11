
package modelo;

public class Esfera extends Cuerpo {
    private double radio;

    public Esfera(double radio) {
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = validarMedida(radio);
    }

    @Override
    public double calcularPerimetro() {
        // Una esfera no tiene perímetro.
        return 0;
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double calcularVolumen() {
        return 4.0 / 3
                * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double[] getMedidas() {
        return new double[]{radio};
    }
}
