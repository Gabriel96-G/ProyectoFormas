
package modelo;

import java.util.Arrays;
import java.util.Locale;

public abstract class Cuerpo implements Forma {

    protected Cuerpo() { }

    protected static double validarMedida(double medida) {
        if (!Double.isFinite(medida) || medida <= 0) {
            throw new IllegalArgumentException(
                    "Las medidas deben ser números positivos y finitos."
            );
        }
        return medida;
    }

    public abstract double calcularVolumen();

    public abstract double[] getMedidas();

    @Override
    public String imprimirInformacion() {
        String perimetro = this instanceof Esfera
                ? "No aplica (0 en el total)"
                : String.format(
                Locale.US, "%.2f", calcularPerimetro()
        );

        return String.format(
                Locale.US,
                "%s | Perímetro/aristas: %s | Área: %.2f | Volumen: %.2f",
                toString(),
                perimetro,
                calcularArea(),
                calcularVolumen()
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
                ((Cuerpo) otro).getMedidas()
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
