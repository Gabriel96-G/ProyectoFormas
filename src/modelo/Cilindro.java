
package modelo;

public class Cilindro extends Cuerpo {
    private Circulo base;
    private Rectangulo lateral;

    public Cilindro(Circulo base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public Circulo getBase() {
        return new Circulo(base.getRadio());
    }

    public Rectangulo getLateral() {
        return new Rectangulo(
                lateral.getBase(),
                lateral.getAltura()
        );
    }

    public double getAltura() {
        return lateral.getAltura();
    }

    public void setBase(Circulo base) {
        if (base == null) {
            throw new IllegalArgumentException(
                    "El cilindro requiere un círculo."
            );
        }

        double alturaAnterior = lateral == null
                ? 1 : lateral.getAltura();

        this.base = new Circulo(base.getRadio());

        lateral = new Rectangulo(
                this.base.calcularPerimetro(),
                alturaAnterior
        );
    }

    public void setAltura(double altura) {
        validarMedida(altura);

        lateral = new Rectangulo(
                base.calcularPerimetro(),
                altura
        );
    }

    @Override
    public double calcularPerimetro() {
        return 2 * base.calcularPerimetro();
    }

    @Override
    public double calcularArea() {
        return 2 * base.calcularArea()
                + lateral.calcularArea();
    }

    @Override
    public double calcularVolumen() {
        return base.calcularArea() * getAltura();
    }

    @Override
    public double[] getMedidas() {
        return new double[]{
                base.getRadio(),
                getAltura()
        };
    }
}
