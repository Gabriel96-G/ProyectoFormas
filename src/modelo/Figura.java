
package modelo;

import java.util.Arrays;
import java.util.Locale;

public abstract class Figura implements Forma {

    protected Figura() { }

    protected static double validarMedida(double medida) {
        if (!Double.isFinite(medida) || medida <= 0) {
            throw new IllegalArgumentException(
                    "Las medidas deben ser números positivos y finitos."
            );
        }
        return medida;
    }

    public abstract double[] getMedidas();

    @Override
    public String imprimirInformacion() {
        return String.format(
                Locale.US,
                "%s | Perímetro: %.2f | Área: %.2f",
                toString(),
                calcularPerimetro(),
                calcularArea()
        );
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) {
            return false;
        }
        return Arrays.equals(
                getMedidas(),
                ((Figura) otro).getMedidas()
        );
    }

    @Override
    public int hashCode() {
        return 31 * getClass().hashCode()
                + Arrays.hashCode(getMedidas());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " " + Arrays.toString(getMedidas());
    }
}
