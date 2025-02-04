import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ServicioConversion {

    // Clave de API de ExchangeRate
    private static final String API_KEY = "67b3230ce826faae30e684bf";  // Reemplaza con tu clave real

    // Obtener la tasa de conversión entre dos monedas
    public static double obtenerTasaConversion(String monedaOrigen, String monedaDestino) {
        try {
            // Formar la URL dinámicamente
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaOrigen;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprimir la respuesta completa para depuración
            System.out.println("Respuesta de la API: " + response);

            // Convertir la respuesta JSON en un objeto
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

            // Verificar si la respuesta tiene la tasa de conversión
            if (jsonResponse.has("conversion_rates") && jsonResponse.getAsJsonObject("conversion_rates").has(monedaDestino)) {
                return jsonResponse.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
            } else {
                System.out.println("Error: No se pudo obtener la tasa de conversión.");
                return -1;
            }

        } catch (Exception e) {
            final Logger LOGGER;
            LOGGER = Logger.getLogger(Clase.class.getName());
            LOGGER.log(Level.SEVERE, "Error al procesar la solicitud", e);
            return -1;  // En caso de error retorna -1
        }
    }

    private static class Clase {
    }
}