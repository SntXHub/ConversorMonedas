import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        ConversorMonedas conversor = new ConversorMonedas();  // Crear instancia del conversor
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
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> convertirMonedas(conversor, scanner);
                case 2 -> mostrarMonedas(conversor);
                case 3 -> actualizarTasas(conversor); // Llamada al método para actualizar tasas
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

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        double resultado = conversor.convertir(cantidad, origen, destino);
        System.out.printf("Resultado: %.2f %s%n", resultado, destino.getCodigo());
    }

    private static Moneda seleccionarMoneda(ConversorMonedas conversor, Scanner scanner) {
        var monedas = conversor.getMonedasDisponibles();
        for (int i = 0; i < monedas.size(); i++) {
            System.out.println((i + 1) + ". " + monedas.get(i).getNombre() + " (" + monedas.get(i).getCodigo() + ")");
        }
        System.out.print("Seleccione una moneda: ");
        int indice = scanner.nextInt() - 1;

        if (indice < 0 || indice >= monedas.size()) {
            System.out.println("Selección inválida. Intente nuevamente.");
            return seleccionarMoneda(conversor, scanner);
        }

        return monedas.get(indice);
    }

    private static void mostrarMonedas(ConversorMonedas conversor) {
        System.out.println("\nMonedas disponibles:");
        for (Moneda moneda : conversor.getMonedasDisponibles()) {
            System.out.println(moneda);
        }
    }

    // Método para actualizar las tasas de conversión
    private static void actualizarTasas(ConversorMonedas conversor) {
        System.out.println("\nActualizando tasas de conversión...");
        conversor.actualizarTasasEnTiempoReal();
    }
}