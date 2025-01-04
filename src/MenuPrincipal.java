import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        ConversorMonedas conversor = new ConversorMonedas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nBienvenido al Conversor de Monedas");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir monedas");
            System.out.println("2. Mostrar monedas disponibles");
            System.out.println("3. Actualizar tasas de conversión");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            // Validación de ingreso de la opción
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                System.out.print("Opción: ");
                scanner.next(); // Descarta la entrada no válida
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> convertirMonedas(conversor, scanner);
                case 2 -> mostrarMonedas(conversor);
                case 3 -> actualizarTasas(conversor);
                case 4 -> System.out.println("¡Gracias por usar el Conversor de Monedas!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void convertirMonedas(ConversorMonedas conversor, Scanner scanner) {
        System.out.println("\nSeleccione la moneda de origen:");
        Moneda origen = seleccionarMoneda(conversor, scanner);
        System.out.println("Seleccione la moneda de destino:");
        Moneda destino = seleccionarMoneda(conversor, scanner);

        double cantidad = -1; // Valor inicial inválido
        boolean entradaValida = false;

        // Validación del monto ingresado
        while (!entradaValida) {
            System.out.print("Ingrese la cantidad a convertir: ");
            if (scanner.hasNextDouble()) { // Si la entrada es un número válido
                cantidad = scanner.nextDouble();
                if (cantidad > 0) { // Verifica si el número es positivo
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, ingrese un número positivo.");
                }
            } else { // Si la entrada no es un número
                System.out.println("Error de entrada. Debe ingresar un valor correcto.");
                scanner.next(); // Descarta el texto inválido
            }
        }

        // Realizar la conversión
        double resultado = conversor.convertir(cantidad, origen, destino);
        System.out.printf("Resultado: %.2f %s%n", resultado, destino.getCodigo());
    }

    private static Moneda seleccionarMoneda(ConversorMonedas conversor, Scanner scanner) {
        var monedas = conversor.getMonedasDisponibles();
        for (int i = 0; i < monedas.size(); i++) {
            System.out.println((i + 1) + ". " + monedas.get(i).getNombre() + " (" + monedas.get(i).getCodigo() + ")");
        }
        System.out.print("Seleccione una moneda: ");

        // Validación de la selección de moneda
        int indice = -1;
        while (indice < 0 || indice >= monedas.size()) {
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next(); // Descarta la entrada no válida
            }
            indice = scanner.nextInt() - 1;

            if (indice < 0 || indice >= monedas.size()) {
                System.out.println("Selección inválida. Intente nuevamente.");
            }
        }

        return monedas.get(indice);
    }

    private static void mostrarMonedas(ConversorMonedas conversor) {
        System.out.println("\nMonedas disponibles:");
        for (Moneda moneda : conversor.getMonedasDisponibles()) {
            System.out.println(moneda);
        }
    }

    // Actualizar las tasas de conversión
    private static void actualizarTasas(ConversorMonedas conversor) {
        System.out.println("\nActualizando tasas de conversión...");
        conversor.actualizarTasasEnTiempoReal();
    }
}