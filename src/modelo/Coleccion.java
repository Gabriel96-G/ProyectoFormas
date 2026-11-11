
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coleccion {
    private final List<Figura> figuras;
    private final List<Cuerpo> cuerpos;

    public Coleccion() {
        figuras = new ArrayList<>();
        cuerpos = new ArrayList<>();
    }

    public List<Figura> getFiguras() {
        return new ArrayList<>(figuras);
    }

    public List<Cuerpo> getCuerpos() {
        return new ArrayList<>(cuerpos);
    }

    public void setFiguras(List<Figura> nuevas) {
        if (nuevas == null || nuevas.contains(null)) {
            throw new IllegalArgumentException("Lista inválida.");
        }
        figuras.clear();
        figuras.addAll(nuevas);
    }

    public void setCuerpos(List<Cuerpo> nuevos) {
        if (nuevos == null || nuevos.contains(null)) {
            throw new IllegalArgumentException("Lista inválida.");
        }
        cuerpos.clear();
        cuerpos.addAll(nuevos);
    }

    public void agregarFigura(Figura figura) {
        if (figura == null) {
            throw new IllegalArgumentException(
                    "La figura no puede ser nula."
            );
        }
        figuras.add(figura);
    }

    public void agregarCuerpo(Cuerpo cuerpo) {
        if (cuerpo == null) {
            throw new IllegalArgumentException(
                    "El cuerpo no puede ser nulo."
            );
        }
        cuerpos.add(cuerpo);
    }

    public double calcularAreaTotal() {
        double total = 0;

        for (Forma figura : figuras) {
            total += figura.calcularArea();
        }

        for (Forma cuerpo : cuerpos) {
            total += cuerpo.calcularArea();
        }

        return total;
    }

    public double calcularPerimetroTotal() {
        double total = 0;

        for (Forma figura : figuras) {
            total += figura.calcularPerimetro();
        }

        for (Forma cuerpo : cuerpos) {
            total += cuerpo.calcularPerimetro();
        }

        return total;
    }

    public double calcularVolumenTotal() {
        double total = 0;

        for (Cuerpo cuerpo : cuerpos) {
            total += cuerpo.calcularVolumen();
        }

        return total;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;

        if (!(otro instanceof Coleccion)) {
            return false;
        }

        Coleccion otra = (Coleccion) otro;

        return figuras.equals(otra.figuras)
                && cuerpos.equals(otra.cuerpos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figuras, cuerpos);
    }

    @Override
    public String toString() {
        return "Coleccion{figuras=" + figuras.size()
                + ", cuerpos=" + cuerpos.size() + "}";
    }
}
