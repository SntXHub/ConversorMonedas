public class Moneda {

    private String nombre;  // Nombre de la moneda (por ejemplo, "Dólar estadounidense")
    private String codigo;  // Código de la moneda (por ejemplo, "USD")
    private double tasaConversion;  // Tasa de conversión respecto a una base (por ejemplo, USD)

    // Constructor
    public Moneda(String nombre, String codigo, double tasaConversion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tasaConversion = tasaConversion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    @Override
    public String toString() {
        return "Moneda: " + nombre + " (" + codigo + "), Tasa de Conversión: " + tasaConversion;
    }
}