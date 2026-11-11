
package modelo;

public class Rombo extends Figura {
    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double diagonalMayor, double diagonalMenor) {
        setDiagonalMayor(diagonalMayor);
        setDiagonalMenor(diagonalMenor);
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    public void setDiagonalMayor(double valor) {
        diagonalMayor = validarMedida(valor);
    }

    public void setDiagonalMenor(double valor) {
        diagonalMenor = validarMedida(valor);
    }

    public double getLado() {
        return Math.sqrt(
                diagonalMayor * diagonalMayor
                        + diagonalMenor * diagonalMenor
        ) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * getLado();
    }

    @Override
    public double calcularArea() {
        return diagonalMayor * diagonalMenor / 2;
    }

    @Override
    public double[] getMedidas() {
        return new double[]{
                diagonalMayor,
                diagonalMenor
        };
    }
}
