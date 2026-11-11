
package vista;

import controlador.ControladorFormas;
import modelo.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner entrada;
    private final ControladorFormas controlador;

    public Menu(ControladorFormas controlador) {
        this.controlador = controlador;
        entrada = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;

        do {
            System.out.println("\n--- PROYECTO FORMAS ---");
            System.out.println("1. Agregar figura");
            System.out.println("2. Agregar cuerpo");
            System.out.println("3. Listar figuras");
            System.out.println("4. Listar cuerpos");
            System.out.println("5. Área total");
            System.out.println("6. Perímetro total");
            System.out.println("7. Volumen total");
            System.out.println("0. Salir");

            opcion = leerEntero("Opción: ");

            try {
                switch (opcion) {
                    case 1:
                        crearFigura();
                        break;

                    case 2:
                        crearCuerpo();
                        break;

                    case 3:
                        listarFiguras();
                        break;

                    case 4:
                        listarCuerpos();
                        break;

                    case 5:
                        System.out.printf(
                                "Área total: %.2f%n",
                                controlador.calcularAreaTotal()
                        );
                        break;

                    case 6:
                        System.out.printf(
                                "Perímetro total: %.2f%n",
                                controlador.calcularPerimetroTotal()
                        );
                        break;

                    case 7:
                        System.out.printf(
                                "Volumen total: %.2f%n",
                                controlador.calcularVolumenTotal()
                        );
                        break;

                    case 0:
                        System.out.println("Hasta luego.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (SQLException | IllegalArgumentException error) {
                System.out.println(
                        "No se pudo completar la operación: "
                                + error.getMessage()
                );
            }

        } while (opcion != 0);
    }

    private void crearFigura() throws SQLException {
        System.out.println(
                "1.Círculo 2.Rectángulo 3.Cuadrado "
                        + "4.Rombo 5.Triángulo"
        );

        int tipo = leerEntero("Figura: ");
        Figura figura;

        switch (tipo) {
            case 1:
                figura = new Circulo(
                        leerMedida("Radio: ")
                );
                break;

            case 2:
                figura = new Rectangulo(
                        leerMedida("Base: "),
                        leerMedida("Altura: ")
                );
                break;

            case 3:
                figura = new Cuadrado(
                        leerMedida("Lado: ")
                );
                break;

            case 4:
                figura = new Rombo(
                        leerMedida("Diagonal 1: "),
                        leerMedida("Diagonal 2: ")
                );
                break;

            case 5:
                double a = leerMedida("Lado 1: ");
                double b = leerMedida("Lado 2: ");
                double c = leerMedida("Lado 3: ");

                figura = FabricaTriangulos.crear(a, b, c);
                break;

            default:
                System.out.println("Figura no válida.");
                return;
        }

        controlador.agregarFigura(figura);

        System.out.println(
                "Guardada: " + figura.imprimirInformacion()
        );
    }

    private void crearCuerpo() throws SQLException {
        System.out.println(
                "1.Cubo 2.Cilindro "
                        + "3.Tetraedro regular 4.Esfera"
        );

        int tipo = leerEntero("Cuerpo: ");
        Cuerpo cuerpo;

        switch (tipo) {
            case 1:
                cuerpo = new Cubo(
                        new Cuadrado(leerMedida("Arista: "))
                );
                break;

            case 2:
                double radio = leerMedida("Radio: ");
                double altura = leerMedida("Altura: ");

                cuerpo = new Cilindro(
                        new Circulo(radio),
                        altura
                );
                break;

            case 3:
                cuerpo = new Tetraedro(
                        new Equilatero(leerMedida("Arista: "))
                );
                break;

            case 4:
                cuerpo = new Esfera(
                        leerMedida("Radio: ")
                );
                break;

            default:
                System.out.println("Cuerpo no válido.");
                return;
        }

        controlador.agregarCuerpo(cuerpo);

        System.out.println(
                "Guardado: " + cuerpo.imprimirInformacion()
        );
    }

    private void listarFiguras() {
        List<Figura> figuras = controlador.getFiguras();

        if (figuras.isEmpty()) {
            System.out.println(
                    "No hay figuras registradas."
            );
        }

        for (Forma figura : figuras) {
            System.out.println(
                    figura.imprimirInformacion()
            );
        }
    }

    private void listarCuerpos() {
        List<Cuerpo> cuerpos = controlador.getCuerpos();

        if (cuerpos.isEmpty()) {
            System.out.println(
                    "No hay cuerpos registrados."
            );
        }

        for (Forma cuerpo : cuerpos) {
            System.out.println(
                    cuerpo.imprimirInformacion()
            );
        }
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);

        try {
            return Integer.parseInt(
                    entrada.nextLine().trim()
            );
        } catch (NumberFormatException error) {
            return -1;
        }
    }

    private double leerMedida(String mensaje) {
        System.out.print(mensaje);

        try {
            return Double.parseDouble(
                    entrada.nextLine()
                            .trim()
                            .replace(',', '.')
            );
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(
                    "Ingrese un número válido."
            );
        }
    }
}
