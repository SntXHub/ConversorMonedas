import java.util.ArrayList;
import java.util.List;

public class ConversorMonedas {

    private final List<Moneda> monedasDisponibles = new ArrayList<>(); // Lista de monedas disponibles para conversión

    // Constructor
    public ConversorMonedas() {
        cargarMonedasIniciales();
    }

    // Metodo para cargar las monedas disponibles
    private void cargarMonedasIniciales() {
        monedasDisponibles.add(new Moneda("Peso Argentino", "ARS", 365.0));
        monedasDisponibles.add(new Moneda("Real Brasileño", "BRL", 5.2));
        monedasDisponibles.add(new Moneda("Peso Mexicano", "MXN", 18.5));
        monedasDisponibles.add(new Moneda("Sol Peruano", "PEN", 3.8));
        monedasDisponibles.add(new Moneda("Bolívar Soberano", "VES", 32.5));
        monedasDisponibles.add(new Moneda("Dólar Estadounidense", "USD", 1.0)); // Base de referencia
        monedasDisponibles.add(new Moneda("Euro", "EUR", 0.85));
        monedasDisponibles.add(new Moneda("Yuan Chino", "CNY", 7.1));
    }

    // Metodo para convertir entre dos monedas
    public double convertir(double cantidad, Moneda origen, Moneda destino) {
        if (origen == null || destino == null) {
            throw new IllegalArgumentException("Las monedas de origen y destino no pueden ser nulas.");
        }
        return cantidad * (destino.getTasaConversion() / origen.getTasaConversion());
    }

    // Metodo para obtener la lista de monedas disponibles
    public List<Moneda> getMonedasDisponibles() {
        return monedasDisponibles;
    }

    // Metodo para tasas de conversión en tiempo real
    public void actualizarTasasEnTiempoReal() {
        for (Moneda moneda : monedasDisponibles) {
            if (!moneda.getCodigo().equals("USD")) { // No actualizamos la base (USD)
                double nuevaTasa = ServicioConversion.obtenerTasaConversion("USD", moneda.getCodigo());
                if (nuevaTasa > 0) {
                    moneda.setTasaConversion(nuevaTasa);
                } else {
                    System.out.println("No se pudo actualizar la tasa para " + moneda.getNombre());
                }
            }
        }
        System.out.println("Tasas de conversión actualizadas en tiempo real.");
    }
}