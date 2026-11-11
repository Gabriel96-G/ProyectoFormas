
package modelo;

public class Tetraedro extends Cuerpo {
    private Equilatero cara;

    public Tetraedro(Equilatero cara) {
        setCara(cara);
    }

    public Equilatero getCara() {
        return new Equilatero(cara.getLado());
    }

    public void setCara(Equilatero cara) {
        if (cara == null) {
            throw new IllegalArgumentException(
                    "El tetraedro regular requiere cara equilátera."
            );
        }

        this.cara = new Equilatero(cara.getLado());
    }

    public double getArista() {
        return cara.getLado();
    }

    @Override
    public double calcularPerimetro() {
        return 6 * getArista();
    }

    @Override
    public double calcularArea() {
        return 4 * cara.calcularArea();
    }

    @Override
    public double calcularVolumen() {
        return Math.sqrt(2)
                * Math.pow(getArista(), 3) / 12;
    }

    @Override
    public double[] getMedidas() {
        return new double[]{getArista()};
    }
}
